package com.cw.model.world;

/**
 * @author:xueshanChen
 * @title:WorldFactory
 * @description:world factory
 * @version: v1.0
 */

public abstract class WorldFactory {
    public WorldFactory(WorldStore worldStore){

    }

    public abstract World create();
}
