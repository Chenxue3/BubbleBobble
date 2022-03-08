package com.cw.model.gameObject;

import com.cw.utility.world.InteractableWorld;
import javafx.scene.image.Image;

/**
 * @author：xueshanChen
 * @title:Heart
 * @description:The heart calss represent to the lives
 * @version: v1.0
 */
public class Heart extends GameObject{
    /**
     * constructor
     *
     * @param interactableWorld the interacble world
     * @param colNum            col in the world
     * @param rowNum            row in the world
     * @param width             width
     * @param height            height
     */
    public Heart(InteractableWorld interactableWorld, int colNum, int rowNum, int width, int height) {
        super(interactableWorld, colNum, rowNum, width, height);
        this.image = new Image("/static/img/bubs/heart.gif");
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
