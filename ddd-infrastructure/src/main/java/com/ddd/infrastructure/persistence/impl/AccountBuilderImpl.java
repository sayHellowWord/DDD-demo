package com.ddd.infrastructure.persistence.impl;

import com.ddd.domains.entity.Account;
import com.ddd.infrastructure.persistence.AccountBuilder;
import com.ddd.infrastructure.persistence.AccountDo;
import com.ddd.types.AccountNumber;
import com.ddd.types.Currency;
import com.ddd.types.Money;
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
public class AccountBuilderImpl implements AccountBuilder {

    @Override
    public Account toAccount(AccountDo accountDo) {
        Account account = new Account();
        account.setId(new AccountId(accountDo.getId()));
        account.setAccountNumber(new AccountNumber(accountDo.getAccountNumber()));
        account.setUserId(new UserId(accountDo.getUserId()));
        Currency currency = new Currency(accountDo.getCurrency());
        account.setAvailable(new Money(accountDo.getAvailableAmount(), currency));
        account.setDailyLimit(new Money(accountDo.getDailyLimitAmount(), currency));
        account.setCurrency(currency);
        return account;
    }

    @Override
    public AccountDo fromAccount(Account account) {
        AccountDo accountDO = new AccountDo();
        if (account.getId() != null) {
            accountDO.setId(account.getId().getValue());
        }
        accountDO.setUserId(account.getUserId().getValue());
        accountDO.setAccountNumber(account.getAccountNumber().getValue());
        accountDO.setAvailableAmount(account.getAvailable().getAmout());
        accountDO.setDailyLimitAmount(account.getDailyLimit().getAmout());
        accountDO.setCurrency(account.getCurrency().getValue());
        return accountDO;
    }
}
