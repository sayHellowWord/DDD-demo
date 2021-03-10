package com.ddd.domains.service;

import com.ddd.domains.entity.Player;
import com.ddd.domains.entity.Weapon;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public interface EquipmentService {

    /**
     * @param player
     * @param weapon
     * @return
     */
    boolean canEquip(Player player, Weapon weapon);

}
