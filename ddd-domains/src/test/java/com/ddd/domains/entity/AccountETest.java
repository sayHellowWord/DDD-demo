package com.ddd.domains.entity;

import com.ddd.exception.DailyLimitExceededException;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.valueobject.Currency;
import com.ddd.types.valueobject.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public class AccountETest {

    @Test
    public void testParamValid4AccountNumber() {
        String accountNumberStr = "123";
        AccountNumber accountNumber = new AccountNumber(accountNumberStr);
        assertEquals(accountNumberStr, accountNumber.getValue());
    }

    @Test
    public void testAccountWithdraw() throws Exception, DailyLimitExceededException {
        AccountE accountE = new AccountE();
        accountE.setId(new AccountId(1L));
        accountE.setAccountNumber(new AccountNumber("123"));
        accountE.setUserId(new UserId(1L));
        Currency currency = new Currency("CNY");
        accountE.setAvailable(new Money(new BigDecimal(500L), currency));
        accountE.setDailyLimit(new Money(new BigDecimal(100L), currency));
        accountE.setCurrency(currency);

        accountE.withdraw(new Money(new BigDecimal(20), currency));

        assertTrue(accountE.getAvailable().equals(new Money(new BigDecimal(480), currency)));

//        account.withdraw(new Money(new BigDecimal(120), currency));

    }
}
