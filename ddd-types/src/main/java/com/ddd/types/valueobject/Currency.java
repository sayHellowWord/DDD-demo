package com.ddd.types.valueobject;

import lombok.Getter;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
@Getter
public class Currency {

    private String value;

    public Currency(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("货币不能为空");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Currency currency = (Currency) o;

        return value != null ? value.equals(currency.value) : currency.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "value='" + value + '\'' +
                '}';
    }
}
