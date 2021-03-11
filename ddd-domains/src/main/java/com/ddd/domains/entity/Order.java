package com.ddd.domains.entity;

import com.ddd.types.common.Entity;
import com.ddd.types.ids.OrderId;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public class Order implements Entity<OrderId> {

    @Override
    public OrderId getId() {
        return null;
    }

}
