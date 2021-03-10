package com.ddd.domains.service;

import com.ddd.domains.entity.Monster;
import com.ddd.domains.entity.Player;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface CombatService {

    void performAttack(Player player, Monster monster);
}
