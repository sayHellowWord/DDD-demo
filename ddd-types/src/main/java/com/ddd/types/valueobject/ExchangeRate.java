package com.ddd.types.valueobject;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public class ExchangeRate {

    private BigDecimal rage;
    private Currency source;
    private Currency target;

    public ExchangeRate(BigDecimal rage, Currency source, Currency target) {
        this.rage = rage;
        this.source = source;
        this.target = target;
    }

    public Money exchangeTo(Money targetMoney) {
        BigDecimal targetMount = targetMoney.getAmout().multiply(rage);
        return new Money(targetMount, target);
    }

}
