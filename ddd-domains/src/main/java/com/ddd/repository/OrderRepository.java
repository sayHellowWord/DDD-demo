package com.ddd.repository;

import com.ddd.domains.entity.Order;
import com.ddd.repository.common.Repository;
import com.ddd.types.ids.OrderId;
import com.ddd.types.ids.StoreId;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface OrderRepository extends Repository<Order, OrderId> {

    // 自定义有多个条件的查询接口
    Order findInStore(OrderId id, StoreId storeId);
}