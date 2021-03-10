package com.ddd.domains.policy.manager;

import com.ddd.domains.entity.Monster;
import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;
import com.ddd.domains.policy.DamagePolicy;
import com.ddd.domains.policy.impl.DragoonPolicy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public class DamageManager {

    private static final List<DamagePolicy> POLICIES = new ArrayList<>();

    static {
        POLICIES.add(new DragoonPolicy());
    }

    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        for (DamagePolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon, monster)) {
                continue;
            }
            return policy.calculateDamage(player, weapon, monster);
        }
        return 0;
    }
}
