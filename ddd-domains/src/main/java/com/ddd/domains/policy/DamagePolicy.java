package com.ddd.domains.policy;

import com.ddd.domains.entity.Monster;
import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface DamagePolicy {

    boolean canApply(Player player, Weapon weapon, Monster monster);

    int calculateDamage(Player player, Weapon weapon, Monster monster);
}
