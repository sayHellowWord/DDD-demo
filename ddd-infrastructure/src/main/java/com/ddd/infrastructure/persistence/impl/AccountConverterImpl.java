package com.ddd.infrastructure.persistence.impl;

import com.ddd.domains.entity.AccountE;
import com.ddd.infrastructure.persistence.AccountConverter;
import com.ddd.infrastructure.persistence.AccountDO;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.valueobject.Currency;
import com.ddd.types.valueobject.Money;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;
import org.springframework.stereotype.Component;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Component
public class AccountConverterImpl implements AccountConverter {

    @Override
    public AccountE toAccount(AccountDO accountDo) {
        AccountE accountE = new AccountE();
        accountE.setId(new AccountId(accountDo.getId()));
        accountE.setAccountNumber(new AccountNumber(accountDo.getAccountNumber()));
        accountE.setUserId(new UserId(accountDo.getUserId()));
        Currency currency = new Currency(accountDo.getCurrency());
        accountE.setAvailable(new Money(accountDo.getAvailableAmount(), currency));
        accountE.setDailyLimit(new Money(accountDo.getDailyLimitAmount(), currency));
        accountE.setCurrency(currency);
        return accountE;
    }

    @Override
    public AccountDO fromAccount(AccountE accountE) {
        AccountDO accountDO = new AccountDO();
        if (accountE.getId() != null) {
            accountDO.setId(accountE.getId().getValue());
        }
        accountDO.setUserId(accountE.getUserId().getValue());
        accountDO.setAccountNumber(accountE.getAccountNumber().getValue());
        accountDO.setAvailableAmount(accountE.getAvailable().getAmount());
        accountDO.setDailyLimitAmount(accountE.getDailyLimit().getAmount());
        accountDO.setCurrency(accountE.getCurrency().getValue());
        return accountDO;
    }
}
