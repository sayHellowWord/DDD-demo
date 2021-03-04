package com.ddd.application;

import com.ddd.exception.DailyLimitExceededException;

import com.ddd.types.common.Result;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/3.
 *
 * @author wubo15
 * @date 2021/3/3
 */
public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) throws Exception, DailyLimitExceededException;
}
