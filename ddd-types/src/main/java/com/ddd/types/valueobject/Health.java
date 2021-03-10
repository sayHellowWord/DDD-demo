package com.ddd.types.valueobject;

import lombok.Getter;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
@Getter
public class Health {

    private int bloodVolume;

    public Health(int bloodVolume) {
        this.bloodVolume = bloodVolume;
    }


}
