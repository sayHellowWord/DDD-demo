package com.ddd.application.impl;

import com.ddd.application.TransferCmdExeService;
import com.ddd.domains.entity.Account;
import com.ddd.domains.event.AccountEvent;
import com.ddd.domains.service.AccountTransferDomainService;
import com.ddd.event.AccountEventProducer;
import com.ddd.exception.DailyLimitExceededException;
import com.ddd.external.ExchangeRateService;
import com.ddd.repository.AccountRepository;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.valueobject.Currency;
import com.ddd.types.valueobject.ExchangeRate;
import com.ddd.types.valueobject.Money;
import com.ddd.types.common.Result;
import com.ddd.types.ids.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/2.
 *
 * @author wubo15
 * @date 2021/3/2
 */
@Service
public class TransferCmdExeServiceImpl implements TransferCmdExeService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountEventProducer accountEventProducer;

    @Autowired
    private ExchangeRateService exchangeRateService;

    /**
     * 当前缺陷，领域服务于Spring耦合到期（业务逻辑与框架绑定）
     */
    @Autowired
    private AccountTransferDomainService accountTransferDomainService;

    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException {

        /**
         * 参数校验
         */
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        /**
         * 读取数据
         */
        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(targetMoney.getCurrency(), sourceAccount.getCurrency());

        /**
         * 业务逻辑
         */
        accountTransferDomainService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        /**
         * 保存数据
         *
         * 事物一致性保证：放到编排层当前看暂无问题，后续可放到repository
         *
         */
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        /**
         * 发送审计消息
         */
        AccountEvent message = new AccountEvent(sourceAccount, targetAccount, targetMoney);
        accountEventProducer.send(message);

        return Result.success(true);
    }
}
