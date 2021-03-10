package com.ddd.domains.policy;

import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public interface EquipmentPolicy {

    boolean canApply(Player player, Weapon weapon);

    boolean canEquip(Player player, Weapon weapon);
}
