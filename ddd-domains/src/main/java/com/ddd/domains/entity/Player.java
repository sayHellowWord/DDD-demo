package com.ddd.domains.entity;

import com.ddd.domains.service.EquipmentService;
import com.ddd.types.enums.PlayerClass;
import com.ddd.types.ids.PlayerId;
import com.ddd.types.ids.WeaponId;
import com.ddd.types.valueobject.Transform;
import com.ddd.types.valueobject.Vector;
import lombok.Getter;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
@Getter
public class Player implements Movable {

    private PlayerId id;
    private String name;
    private PlayerClass playerClass; // enum
    private WeaponId weaponId; // （Note 1）
    private Transform position = Transform.ORIGIN;
    private Vector vector = Vector.ZERO;

    @Override
    public void moveTo(long x, long y) {
        this.position = new Transform(x, y);
    }

    @Override
    public void startMove(long velocityX, long velocityY) {
        this.vector = new Vector(velocityX, velocityY);
    }

    @Override
    public void stopMove() {
        this.vector = Vector.ZERO;
    }

    @Override
    public boolean isMoving() {
        return this.vector.getX() != 0 || this.vector.getY() != 0;
    }

    @Override
    public Transform getPosition() {
        return position;
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    public void equip(Weapon weapon, EquipmentService equipmentService) {
        if (equipmentService.canEquip(this, weapon)) {
            this.weaponId = weapon.getId();
        } else {
            throw new IllegalArgumentException("Cannot Equip: " + weapon);
        }
    }
}
