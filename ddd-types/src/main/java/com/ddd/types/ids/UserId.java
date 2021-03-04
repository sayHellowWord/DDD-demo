package com.ddd.types.ids;

import com.ddd.types.common.Id;

/**
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
public class UserId extends Id {

    private Long id;

    public UserId(Long id) {
        if (id == null || 0 == id) {
            throw new IllegalArgumentException("账号不能为空");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
