package com.ddd.infrastructure.persistence.impl;

import com.ddd.domains.entity.Account;
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
    public Account toAccount(AccountDO accountDo) {
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
    public AccountDO fromAccount(Account account) {
        AccountDO accountDO = new AccountDO();
        if (account.getId() != null) {
            accountDO.setId(account.getId().getValue());
        }
        accountDO.setUserId(account.getUserId().getValue());
        accountDO.setAccountNumber(account.getAccountNumber().getValue());
        accountDO.setAvailableAmount(account.getAvailable().getAmount());
        accountDO.setDailyLimitAmount(account.getDailyLimit().getAmount());
        accountDO.setCurrency(account.getCurrency().getValue());
        return accountDO;
    }
}
