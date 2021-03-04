package com.ddd.domains.service.impl;

import com.ddd.domains.entity.AccountE;
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
    public void transfer(AccountE sourceAccountE, AccountE targetAccountE, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccountE.withdraw(sourceMoney);
        targetAccountE.deposit(targetMoney);
    }


}
