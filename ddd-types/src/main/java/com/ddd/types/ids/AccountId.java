package com.ddd.types.ids;

import com.ddd.types.common.Id;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */

public class AccountId extends Id {

    private AccountId() {

    }

    public AccountId(Long value) {
        //校验

        this.value = value;
    }


}
