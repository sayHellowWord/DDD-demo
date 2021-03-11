package com.ddd.infrastructure.repository;

import com.ddd.types.common.Entity;
import com.ddd.types.common.Identifier;
import com.ddd.types.enums.EntityDiff;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public class ThreadLocalEntityManager<T extends Entity<ID>, ID extends Identifier> implements AggregateManager<T, ID> {

    private ThreadLocal<DbContext<T, ID>> context;
    private Class<? extends T> targetClass;

    public ThreadLocalEntityManager(Class<? extends T> targetClass) {
        this.targetClass = targetClass;
        this.context = ThreadLocal.withInitial(() -> new DbContext<T, ID>(targetClass));
    }

    @Override
    public void attach(T aggregate) {
        context.get().attach(aggregate);
    }

    @Override
    public void attach(T aggregate, ID id) {
        context.get().setId(aggregate, id);
        context.get().attach(aggregate);
    }

    @Override
    public void detach(T aggregate) {
        context.get().detach(aggregate);
    }

    @Override
    public T find(ID id) {
        return context.get().find(id);
    }

    @Override
    public EntityDiff detectChanges(T aggregate) {
        return context.get().detectChanges(aggregate);
    }

    @Override
    public void merge(T aggregate) {
        context.get().merge(aggregate);
    }
}