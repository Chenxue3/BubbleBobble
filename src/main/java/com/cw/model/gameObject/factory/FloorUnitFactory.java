package com.cw.model.gameObject.factory;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.GameObject;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:FloorUnitFactory
 * @description:Floor Unit Factory
 * @version: v1.0
 */

public class FloorUnitFactory extends GameFactory {
    public FloorUnitFactory(GameStore gameStore) {
        super(gameStore);
        gameStore.newObj("FloorUnit",this);
    }

    @Override
    public GameObject create(InteractableWorld interactableWorld, int col, int row) {
        return new FloorUnit(interactableWorld,col,row);
    }
}
