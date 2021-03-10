package com.ddd.domains.policy.impl;

import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;
import com.ddd.domains.policy.EquipmentPolicy;
import com.ddd.types.enums.PlayerClass;
import com.ddd.types.enums.WeaponType;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public class FighterEquipmentPolicy implements EquipmentPolicy {

    @Override
    public boolean canApply(Player player, Weapon weapon) {
        return player.getPlayerClass() == PlayerClass.Fighter;
    }

    /**
     * Fighter能装备Sword和Dagger
     */
    @Override
    public boolean canEquip(Player player, Weapon weapon) {
        return weapon.getWeaponType() == WeaponType.Sword
                || weapon.getWeaponType() == WeaponType.Dagger;
    }
}