package com.ddd.domains.entity;

import com.ddd.types.enums.WeaponType;
import com.ddd.types.ids.WeaponId;
import lombok.Getter;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
@Getter
public class Weapon {

    private WeaponId id;
    private String name;
    private WeaponType weaponType; // enum
    private int damage;
    private int damageType; // 0 - physical, 1 - fire, 2 - ice

}
