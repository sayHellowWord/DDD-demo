package com.ddd.domains.service.impl;

import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;
import com.ddd.domains.policy.manager.EquipmentManager;
import com.ddd.domains.service.EquipmentService;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentManager equipmentManager;

    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return equipmentManager.canEquip(player, weapon);
    }
}
