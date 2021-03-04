package com.ddd.types.valueobject;

import com.ddd.types.exception.MoneyAmountNotNullException;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
public class Money {

    private BigDecimal amount;

    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int compareTo(Money money) {
        return this.amount.compareTo(money.getAmount());
    }

    public Money subtract(Money money) throws Exception {
        BigDecimal resultAmout = this.amount.subtract(money.getAmount());
        return new Money(resultAmout, this.currency);
    }


    public Money add(Money money) throws MoneyAmountNotNullException {
        BigDecimal resultAmout = this.amount.add(money.getAmount());
        return new Money(resultAmout, this.currency);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        if (amount != null ? !amount.equals(money.amount) : money.amount != null) {
            return false;
        }
        return currency != null ? currency.equals(money.currency) : money.currency == null;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
