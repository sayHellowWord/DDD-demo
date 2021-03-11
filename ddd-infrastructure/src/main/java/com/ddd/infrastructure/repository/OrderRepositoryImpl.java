package com.ddd.infrastructure.repository;

import com.ddd.domains.entity.Order;
import com.ddd.repository.OrderRepository;
import com.ddd.types.enums.EntityDiff;
import com.ddd.types.ids.OrderId;
import com.ddd.types.ids.StoreId;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public class OrderRepositoryImpl extends DbRepositorySupport<Order, OrderId> implements OrderRepository {

    protected OrderRepositoryImpl(Class<Order> targetClass) {
        super(targetClass);
    }

    @Override
    protected void onInsert(Order aggregate) {

    }

    @Override
    protected Order onSelect(OrderId orderId) {
        return null;
    }

    @Override
    protected void onUpdate(Order aggregate, EntityDiff diff) {

    }

    @Override
    protected void onDelete(Order aggregate) {

    }

    @Override
    public Order findInStore(OrderId id, StoreId storeId) {
        return null;
    }
}
