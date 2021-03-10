package com.ddd.repository;

import com.ddd.domains.entity.Weapon;
import com.ddd.types.ids.WeaponId;

/**
 * Created by wubo15 on 2021/3/10.
 *
 * @author wubo15
 * @date 2021/3/10
 */
public interface WeaponRepository {

    Weapon find(WeaponId weaponId);

}
