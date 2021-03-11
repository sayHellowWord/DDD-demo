package com.ddd.types.common;

/**
 * 聚合根的Marker接口
 * <p>
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface Aggregate<ID extends Identifier> extends Entity<ID> {

}