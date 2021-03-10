package com.ddd.domains.entity;

import com.ddd.types.enums.MonsterClass;
import com.ddd.types.ids.MonsterId;
import com.ddd.types.valueobject.Health;
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
public class Monster implements Movable {

    private MonsterId id;
    private MonsterClass monsterClass; // enum
    private Health health;
    private Transform position = Transform.ORIGIN;
    private Vector velocity = Vector.ZERO;


    public void takeDamage(int damage) {
        this.health = new Health(this.health.getBloodVolume() - damage);
    }

    @Override
    public Transform getPosition() {
        return null;
    }

    @Override
    public Vector getVector() {
        return null;
    }

    @Override
    public void moveTo(long x, long y) {

    }

    @Override
    public void startMove(long velX, long velY) {

    }

    @Override
    public void stopMove() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }
}
