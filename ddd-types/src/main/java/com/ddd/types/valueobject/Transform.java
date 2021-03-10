package com.ddd.types.valueobject;

import lombok.Value;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
@Value
public class Transform {

    public static final Transform ORIGIN = new Transform(0, 0);

    long x;
    long y;

    
}
