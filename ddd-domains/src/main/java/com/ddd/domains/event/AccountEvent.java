package com.ddd.domains.event;

import com.ddd.domains.entity.Account;
import com.ddd.types.Money;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
@Getter
@ToString
public class AccountEvent {

    private Account sourceAccount;

    private Account targetAccount;

    private Money targetMoney;

    private AccountEvent() {
    }

    public AccountEvent(Account sourceAccount, Account targetAccount, Money targetMoney) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.targetMoney = targetMoney;
    }


}
