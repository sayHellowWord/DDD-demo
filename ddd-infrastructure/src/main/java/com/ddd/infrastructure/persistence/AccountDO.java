package com.ddd.infrastructure.persistence;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
@Data
public class AccountDO {

    private Long id;
    private String accountNumber;
    private Long userId;
    private BigDecimal availableAmount;
    private BigDecimal dailyLimitAmount;
    private String currency;

    @Override
    public String toString() {
        return "AccountDO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", userId=" + userId +
                ", availableAmout=" + availableAmount +
                ", dailyLimitAmout=" + dailyLimitAmount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
