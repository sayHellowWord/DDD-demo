package com.ddd.external;

import com.ddd.types.Currency;
import com.ddd.types.ExchangeRate;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);

}
