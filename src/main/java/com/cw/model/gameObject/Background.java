package com.cw.model.gameObject;

import com.cw.utility.ImageManagement;
import com.cw.utility.world.Director;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author:xueshanChen
 * @title:Background
 * @description:Create the background
 * @version: v1.0
 */

public class Background extends GameObject {


    public Background(InteractableWorld world) {
        super(world,0,0, Director.UNIT_SIZE*Director.WIDTH,Director.UNIT_SIZE*Director.HEIGHT);
    }

    @Override
    public void paint(GraphicsContext graphicsContext) {
        image = ImageManagement.bgImage;
        super.paint(graphicsContext);
    }

    @Override
    public void collideWithFloor() {

    }

    @Override
    public void collideWithCeiling() {

    }

    @Override
    public void collideWithWall() {

    }
}
