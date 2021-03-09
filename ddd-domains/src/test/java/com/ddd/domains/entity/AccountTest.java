package com.ddd.domains.entity;

import com.ddd.exception.DailyLimitExceededException;
import com.ddd.types.ids.AccountId;
import com.ddd.types.ids.UserId;
import com.ddd.types.valueobject.AccountNumber;
import com.ddd.types.valueobject.Currency;
import com.ddd.types.valueobject.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;


/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public class AccountTest {

    @Test
    @DisplayName("账户编码验证")
    public void testParamValid4AccountNumber() {
        String accountNumberStr = "123";
        AccountNumber accountNumber = new AccountNumber(accountNumberStr);
        Assertions.assertEquals(accountNumber.getValue(), accountNumberStr);
    }

    @Test
    @DisplayName("账户正常转出+超过日限额转出")
    public void testAccountWithdraw() throws Exception, DailyLimitExceededException {
        Account account = new Account();
        account.setId(new AccountId(1L));
        account.setAccountNumber(new AccountNumber("123"));
        account.setUserId(new UserId(1L));
        Currency currency = new Currency("CNY");
        account.setAvailable(new Money(new BigDecimal(500L), currency));
        account.setDailyLimit(new Money(new BigDecimal(100L), currency));
        account.setCurrency(currency);

        account.withdraw(new Money(new BigDecimal(20), currency));
        Assertions.assertEquals(account.getAvailable(), new Money(new BigDecimal(480), currency));

//        org.assertj.core.api.Assertions

        Assertions.assertThrows(DailyLimitExceededException.class, () -> account.withdraw(new Money(new BigDecimal(120), currency)));

    }
}
