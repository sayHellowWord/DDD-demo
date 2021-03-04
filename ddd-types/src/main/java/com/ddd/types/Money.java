package com.ddd.types;

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

    public BigDecimal getAmout() {
        return amount;
    }

    public int compareTo(Money money) {
        return this.amount.compareTo(money.getAmout());
    }

    public Money subtract(Money money) throws Exception {
        BigDecimal resultAmout = this.amount.subtract(money.getAmout());
        return new Money(resultAmout, this.currency);
    }


    public Money add(Money money) throws MoneyAmountNotNullException {
        BigDecimal resultAmout = this.amount.add(money.getAmout());
        return new Money(resultAmout, this.currency);
    }
}
