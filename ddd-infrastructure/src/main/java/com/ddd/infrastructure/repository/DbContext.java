package com.ddd.infrastructure.repository;

import com.ddd.types.common.Aggregate;
import com.ddd.types.common.Entity;
import com.ddd.types.common.Identifier;
import com.ddd.types.enums.EntityDiff;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public class DbContext<T extends Entity<ID>, ID extends Identifier> {


    private Class<? extends T> aggregateClass;

    private Map<ID, T> aggregateMap = new HashMap<>();

    public DbContext(Class<? extends T> aggregateClass) {
        this.aggregateClass = aggregateClass;
    }

    public void attach(T aggregate) {
        if (aggregate.getId() != null) {
            if (!aggregateMap.containsKey(aggregate.getId())) {
                this.merge(aggregate);
            }
        }
    }

    public void detach(T aggregate) {
        if (aggregate.getId() != null) {
            aggregateMap.remove(aggregate.getId());
        }
    }

    public EntityDiff detectChanges(T aggregate) {
        if (aggregate.getId() == null) {
            return EntityDiff.EMPTY;
        }
        T snapshot = aggregateMap.get(aggregate.getId());
        if (snapshot == null) {
            attach(aggregate);
        }
//        return DiffUtils.diff(snapshot, aggregate);
        return EntityDiff.EMPTY;
    }

    public T find(ID id) {
        return aggregateMap.get(id);
    }

    public void merge(T aggregate) {
        if (aggregate.getId() != null) {
//            T snapshot = SnapshotUtils.snapshot(aggregate);
//            aggregateMap.put(aggregate.getId(), snapshot);
        }
    }

    public void setId(T aggregate, ID id) {
//        ReflectionUtils.writeField("id", aggregate, id);
    }


}
