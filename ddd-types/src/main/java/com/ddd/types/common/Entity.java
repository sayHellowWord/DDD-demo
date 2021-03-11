package com.ddd.types.common;

/**
 * 实体类的Marker接口
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface Entity<ID extends Identifier> extends Identifiable<ID> {

}