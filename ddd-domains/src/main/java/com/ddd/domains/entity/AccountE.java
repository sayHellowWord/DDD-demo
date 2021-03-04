package com.ddd.domains.entity;

import com.ddd.exception.DailyLimitExceededException;
import com.ddd.exception.InsufficientFundsException;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.valueobject.Currency;
import com.ddd.types.valueobject.Money;
import com.ddd.types.exception.InvalidCurrencyException;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
@Setter
@Getter
public class AccountE {

    private AccountId id;

    private AccountNumber accountNumber;

    private UserId userId;

    private Money available;

    private Money dailyLimit;

    private Currency currency;

    public AccountE() {
    }

    public AccountE(AccountId id, AccountNumber accountNumber, UserId userId, Money available, Money dailyLimit, Currency currency) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.available = available;
        this.dailyLimit = dailyLimit;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    /**
     * 转出
     *
     * @param money
     */
    public void withdraw(Money money) throws Exception, DailyLimitExceededException {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }

        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }

        this.available = this.available.subtract(money);
    }

    /**
     * 转入
     *
     * @param money
     */
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);
    }

}
