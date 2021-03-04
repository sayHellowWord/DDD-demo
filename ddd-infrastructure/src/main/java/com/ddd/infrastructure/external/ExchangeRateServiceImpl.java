package com.ddd.infrastructure.external;

import com.ddd.external.ExchangeRateService;
import com.ddd.types.valueobject.Currency;
import com.ddd.types.valueobject.ExchangeRate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        } else {
            /**
             * 调用汇率服务
             */
            return new ExchangeRate(new BigDecimal(10), source, target);
        }
    }


}
