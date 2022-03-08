package com.cw.model;

import com.cw.model.gameObject.GameObject;
import com.cw.utility.world.InteractableWorld;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xueshanChen
 * @title:GameStore
 * @description:the store create factory of all the objects
 * @version: v1.0
 */

public class GameStore {

    private Map<String, GameFactory> objMap;

    /**
     * constructor of create a game store to generate a game object
     */
    public GameStore(){
        this.objMap = new HashMap<>();
    }

    /**
     * generate a obj
     * @param key the key to get the object from map
     * @param gameFactory the game factory
     */
    public void newObj(String key, GameFactory gameFactory){
        objMap.put(key, gameFactory);
    }

    /**
     * @param key the key to get the object from map
     * @param world InteractableWorld
     * @param col the col
     * @param row the row
     * @return the map which stores all the game objects
     */
    public GameObject create(String key, InteractableWorld world, int col, int row) {
        return objMap.get(key).create( world, col, row);
    }

}
