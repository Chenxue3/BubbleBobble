package com.cw.model.mapUnits;

import com.cw.model.gameObject.GameObject;
import com.cw.utility.ImageManagement;
import com.cw.utility.world.Director;
import com.cw.utility.world.InteractableWorld;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * @author:xueshanChen
 * @title:FloorUnit
 * @description:The FloorUnit class creates floor units to be used for the world.
 * @version: v1.0
 */
public class FloorUnit extends GameObject {
    public FloorUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, Director.UNIT_SIZE, Director.UNIT_SIZE);
    }

    @Override
    public void paint(GraphicsContext graphicsContext) {
        image = ImageManagement.unitImage;
        super.paint(graphicsContext);
    }

    @Override
    public void collideWithFloor() {

    }

    /**
     * check floor collide with obj
     * @param obj game object
     */
    public void collideWith(GameObject obj) {
        double top = obj.getY();
        double bottom = top + obj.getHeight();
        if (this.overlaps(obj) && obj.yVelocity > 0) {
            if (bottom < y + height) {
                moveAboveUnit(obj);
                obj.collideWithFloor();
            }
            if (top > y){
                moveBelowUnit(obj);
                obj.collideWithCeiling();
            }
        }
    }

    /**
     * move
     * @param obj gameObject
     */
    void moveAboveUnit(GameObject obj) {
        obj.moveTo(new Point2D(obj.getX(), y - obj.getHeight()));
    }

    void moveBelowUnit(GameObject obj) {
        obj.moveTo(new Point2D(obj.getX(), y + height));
    }
    @Override
    public void collideWithCeiling() {

    }

    @Override
    public void collideWithWall() {

    }
}
