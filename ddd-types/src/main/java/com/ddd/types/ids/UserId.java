package com.ddd.types.ids;

import com.ddd.types.common.Id;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
public class UserId extends Id {

    public UserId(Long value) {
        if (value == null || 0 == value) {
            throw new IllegalArgumentException("账号不能为空");
        }
        this.value = value;
    }

}
