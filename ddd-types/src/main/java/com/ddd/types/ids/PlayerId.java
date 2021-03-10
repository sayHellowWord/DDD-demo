package com.ddd.types.ids;

import com.ddd.types.common.Id;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public class PlayerId extends Id {

    private PlayerId() {

    }

    public PlayerId(Long value) {
        //校验

        this.value = value;
    }


}
