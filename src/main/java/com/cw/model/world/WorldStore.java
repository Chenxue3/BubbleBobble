package com.cw.model.world;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xueshanChen
 * @title:WorldStore
 * @description:create world
 * @version: v1.0
 */

public class WorldStore {
    private Map<String, WorldFactory> worldStore;
    public WorldStore(){
        this.worldStore = new HashMap<>();
    }

    public void store(String str, WorldFactory worldFactory){
        worldStore.put(str,worldFactory);
    }

    public World create(String str){
        return worldStore.get(str).create();
    }
}
