package com.ddd.domains.policy.manager;

import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;
import com.ddd.domains.policy.EquipmentPolicy;
import com.ddd.domains.policy.impl.FighterEquipmentPolicy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public class EquipmentManager {

    private static final List<EquipmentPolicy> POLICIES = new ArrayList<>();

    static {
        POLICIES.add(new FighterEquipmentPolicy());
    }

    public boolean canEquip(Player player, Weapon weapon) {
        for (EquipmentPolicy policy : POLICIES) {
            if (!policy.canApply(player, weapon)) {
                continue;
            }
            return policy.canEquip(player, weapon);
        }
        return false;
    }
}
