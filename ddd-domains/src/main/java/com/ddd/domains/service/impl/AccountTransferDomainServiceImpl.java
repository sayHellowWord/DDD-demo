package com.ddd.domains.service.impl;

import com.ddd.domains.entity.Account;
import com.ddd.domains.service.AccountTransferDomainService;
import com.ddd.exception.DailyLimitExceededException;
import com.ddd.types.valueobject.ExchangeRate;
import com.ddd.types.valueobject.Money;
import org.springframework.stereotype.Service;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Service
public class AccountTransferDomainServiceImpl implements AccountTransferDomainService {

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.withdraw(sourceMoney);
        targetAccount.deposit(targetMoney);
    }


}
