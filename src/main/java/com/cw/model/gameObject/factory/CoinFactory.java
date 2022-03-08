package com.cw.model.gameObject.factory;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.Coin;
import com.cw.model.gameObject.GameObject;
import com.cw.utility.world.InteractableWorld;

/**
 * @author:xueshanChen
 * @title:CoinFactory
 * @description:factory of coin
 * @version: v1.0
 */

public class CoinFactory extends GameFactory {
    public CoinFactory(GameStore gameStore) {
        super(gameStore);
        gameStore.newObj("Coin",this);
    }

    @Override
    public GameObject create(InteractableWorld interactableWorld, int col, int row) {
        return new Coin(interactableWorld,col,row);
    }
}
