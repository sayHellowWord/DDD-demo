package com.ddd.domains.service.impl;

import com.ddd.domains.entity.Account;
import com.ddd.domains.service.AccountTransferService;
import com.ddd.exception.DailyLimitExceededException;
import com.ddd.external.ExchangeRateService;
import com.ddd.types.ExchangeRate;
import com.ddd.types.Money;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public class AccountTransferServiceImpl implements AccountTransferService {

    private ExchangeRateService exchangeRateService;

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }


}
