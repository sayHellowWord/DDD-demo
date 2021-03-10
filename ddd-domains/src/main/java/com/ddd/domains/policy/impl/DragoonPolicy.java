package com.ddd.domains.policy.impl;

import com.ddd.domains.entity.Monster;
import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;
import com.ddd.domains.policy.DamagePolicy;
import com.ddd.types.enums.MonsterClass;
import com.ddd.types.enums.PlayerClass;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public class DragoonPolicy implements DamagePolicy {

    @Override
    public int calculateDamage(Player player, Weapon weapon, Monster monster) {
        return weapon.getDamage() * 2;
    }

    @Override
    public boolean canApply(Player player, Weapon weapon, Monster monster) {
        return player.getPlayerClass() == PlayerClass.Dragoon &&
                monster.getMonsterClass() == MonsterClass.Dragon;
//                && player.equip(weapon,);
    }
}
