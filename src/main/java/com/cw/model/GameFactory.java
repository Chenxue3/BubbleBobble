package com.cw.model;

import com.cw.model.gameObject.GameObject;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:GameFactory
 * @description:the factory of all the game objects
 * @version: v1.0
 */

public abstract class GameFactory {
    public GameFactory(GameStore gameStore) {
    }

    public  abstract GameObject create(InteractableWorld interactableWorld, int col, int row);
}
