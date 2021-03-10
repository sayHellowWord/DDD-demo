package com.ddd.domains.entity;

import com.ddd.types.valueobject.Transform;
import com.ddd.types.valueobject.Vector;

/**
 * Created by wubo15 on 2021/3/9.
 *
 * @author wubo15
 * @date 2021/3/9
 */
public interface Movable {

    //相当于组件

    /**
     * @return
     */
    Transform getPosition();

    /**
     * @return
     */
    Vector getVector();


    //行为

    /**
     * @param x
     * @param y
     */
    void moveTo(long x, long y);

    /**
     * @param velX
     * @param velY
     */
    void startMove(long velX, long velY);

    /**
     *
     */
    void stopMove();

    /**
     * @return
     */
    boolean isMoving();

}
