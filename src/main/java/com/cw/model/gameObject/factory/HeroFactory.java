package com.cw.model.gameObject.factory;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.GameObject;
import com.cw.model.gameObject.Hero;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:HeroFactory
 * @description:Hero factory
 * @version: v1.0
 */

public class HeroFactory extends GameFactory {
    public HeroFactory(GameStore gameStore) {
        super(gameStore);
        gameStore.newObj("Hero",this);
    }

    @Override
    public GameObject create(InteractableWorld interactableWorld, int col, int row) {
        return new Hero(interactableWorld,col,row);
    }
}
