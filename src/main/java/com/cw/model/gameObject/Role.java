package com.cw.model.gameObject;

import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:Role
 * @description:define the roles
 * @version: v1.0
 */

public interface Role{

    void role(int x, int y, int width, int height, InteractableWorld world);

    /**
     * define how the object moving
     */
    public abstract void move();
}
