package com.ddd.types.exception;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public class MoneyAmountNotNullException extends IllegalArgumentException {

    public MoneyAmountNotNullException(String message) {
        super(message);
    }


}
