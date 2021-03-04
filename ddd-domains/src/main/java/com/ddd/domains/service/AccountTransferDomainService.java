package com.ddd.domains.service;

import com.ddd.domains.entity.Account;
import com.ddd.exception.DailyLimitExceededException;
import com.ddd.types.valueobject.ExchangeRate;
import com.ddd.types.valueobject.Money;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public interface AccountTransferDomainService {

    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) throws Exception, DailyLimitExceededException;


}
