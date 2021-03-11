package com.ddd.types.enums;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public enum EntityDiff {
    EMPTY("空"),
    ;

    private String name;


    EntityDiff(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
