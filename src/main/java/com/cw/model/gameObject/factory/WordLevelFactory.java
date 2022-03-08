package com.cw.model.gameObject.factory;

import com.cw.model.world.World;
import com.cw.model.world.WorldFactory;
import com.cw.model.world.WorldStore;

/**
 * @author:xueshanChen
 * @title:WordLevelFactory
 * @description:world level
 * @version: v1.0
 */

public class WordLevelFactory extends WorldFactory {
    String level;
    public WordLevelFactory(WorldStore worldStore, String level) {
        super(worldStore);
        if(level.equals("hard")){
            worldStore.create(level).setRankTableFile(World.RANK3);
            worldStore.create(level).setThisWorld(World.WORLD3);
        }
        else if(level.equals("easy")){
            worldStore.create(level).setRankTableFile(World.RANK1);
            worldStore.create(level).setThisWorld(World.WORLD1);
        }
        else if(level.equals("middle")){
            worldStore.create(level).setRankTableFile(World.RANK2);
            worldStore.create(level).setThisWorld(World.WORLD2);
        }
    }

    @Override
    public World create() {
        return null;
    }
}
