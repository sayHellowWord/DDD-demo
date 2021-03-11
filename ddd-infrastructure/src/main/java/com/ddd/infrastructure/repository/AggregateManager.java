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
public interface AggregateManager<T extends Entity<ID>, ID extends Identifier> {

    static <ID extends Identifier, T extends Entity<ID>> AggregateManager<T, ID> newInstance(Class<T> targetClass) {
        return null;
    }

    void attach(T aggregate);

    void attach(T aggregate, ID id);

    void detach(T aggregate);

    T find(ID id);

    EntityDiff detectChanges(T aggregate);

    void merge(T aggregate);
}
