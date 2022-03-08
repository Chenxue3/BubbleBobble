package com.cw.model.gameObject.factory;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.GameObject;
import com.cw.model.mapUnits.CeilingUnit;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:CeilingUnitFactory
 * @description:factory creating the ceiling units
 * @version: v1.0
 */

public class CeilingUnitFactory extends GameFactory {
    public CeilingUnitFactory(GameStore gameStore) {
        super(gameStore);
        gameStore.newObj("CeilingUnit",this);
    }

    @Override
    public GameObject create(InteractableWorld interactableWorld, int col, int row) {
        return new CeilingUnit(interactableWorld,col,row);
    }
}
