package com.ddd.application.impl;

import com.ddd.application.TransferService;
import com.ddd.domains.entity.Account;
import com.ddd.domains.event.AccountEvent;
import com.ddd.domains.service.AccountTransferService;
import com.ddd.event.AccountEventProducer;
import com.ddd.exception.DailyLimitExceededException;
import com.ddd.external.ExchangeRateService;
import com.ddd.repository.AccountRepository;
import com.ddd.repository.TestModuleRepository;
import com.ddd.repository.TestRepository;
import com.ddd.types.AccountNumber;
import com.ddd.types.Currency;
import com.ddd.types.ExchangeRate;
import com.ddd.types.Money;
import com.ddd.types.common.Result;
import com.ddd.types.ids.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/2.
 *
 * @author wubo15
 * @date 2021/3/2
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    private TestRepository testRepository;

    @Resource
    private TestModuleRepository testModuleRepository;

    @Autowired
    private AccountRepository accountRepository;

    private AccountEventProducer accountEventProducer;
    private ExchangeRateService exchangeRateService;
    private AccountTransferService accountTransferService;

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
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        /**
         * 业务逻辑
         */
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        /**
         * 保存数据
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
