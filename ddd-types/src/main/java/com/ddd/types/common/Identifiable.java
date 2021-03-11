package com.ddd.types.common;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface Identifiable<ID extends Identifier> {
    ID getId();
}