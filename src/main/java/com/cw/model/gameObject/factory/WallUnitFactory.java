package com.cw.model.gameObject.factory;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.GameObject;
import com.cw.model.mapUnits.WallUnit;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:WallUnitFactory
 * @description:Wall unit factory
 * @version: v1.0
 */

public class WallUnitFactory extends GameFactory {
    public WallUnitFactory(GameStore gameStore) {
        super(gameStore);
        gameStore.newObj("WallUnit",this);
    }

    @Override
    public GameObject create(InteractableWorld interactableWorld, int col, int row) {
        return new WallUnit(interactableWorld,col,row);
    }
}
