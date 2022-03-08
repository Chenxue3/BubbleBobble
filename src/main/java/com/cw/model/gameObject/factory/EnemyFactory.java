package com.cw.model.gameObject.factory;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.Enemy;
import com.cw.model.gameObject.GameObject;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:EnemyFactory
 * @description:the factory of creating the enemy
 * @version:v1.0
 */

public class EnemyFactory extends GameFactory {


    public EnemyFactory(GameStore gameStore) {
        super(gameStore);
        gameStore.newObj("Enemy",this);
    }

    @Override
    public GameObject create(InteractableWorld interactableWorld, int col, int row) {
        return new Enemy(interactableWorld,col,row);
    }

}
