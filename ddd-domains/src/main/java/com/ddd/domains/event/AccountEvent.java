package com.ddd.domains.event;

import com.ddd.domains.entity.AccountE;
import com.ddd.types.valueobject.Money;
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

    private AccountE sourceAccountE;

    private AccountE targetAccountE;

    private Money targetMoney;

    private AccountEvent() {
    }

    public AccountEvent(AccountE sourceAccountE, AccountE targetAccountE, Money targetMoney) {
        this.sourceAccountE = sourceAccountE;
        this.targetAccountE = targetAccountE;
        this.targetMoney = targetMoney;
    }


}
