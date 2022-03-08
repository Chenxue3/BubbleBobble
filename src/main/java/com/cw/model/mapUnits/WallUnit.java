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
 * @title:WallUnit
 * @description:The WallUnit class creates wall units to be used for the world.
 * A wall unit is an unit shaped like a square that is treated as a wall,
 * with collision on all four sides.
 * The wall collides with any kind of game object.
 * @version: v1.0
 */

public class WallUnit extends GameObject {

	public WallUnit(InteractableWorld world, int colNum, int rowNum) {
		super(world, colNum, rowNum, Director.UNIT_SIZE, Director.UNIT_SIZE);
	}

	public void collideWith(GameObject obj) {
		double center = obj.getHitBox().getCenterX();
		if (this.overlaps(obj)) {
			if (center > this.getHitBox().getCenterX()) {
				moveRightOfUnit(obj);
				obj.collideWithWall();
			} else if (center < this.getHitBox().getCenterX()){
				moveLeftOfUnit(obj);
				obj.collideWithWall();
			} else {
				moveBelowUnit(obj);
				obj.collideWithCeiling();
			}
		}
	}

	@Override
	public void paint(GraphicsContext graphicsContext) {
		image = ImageManagement.unitImage;
		super.paint(graphicsContext);
	}
	void moveAboveUnit(GameObject obj) {
		obj.moveTo(new Point2D(obj.getX(), y - obj.getHeight()));
	}

	void moveBelowUnit(GameObject obj) {
		obj.moveTo(new Point2D(obj.getX(), y + height));
	}

	void moveLeftOfUnit(GameObject obj) {
		obj.moveTo(new Point2D(x - obj.getWidth(), obj.getY()));
	}

	void moveRightOfUnit(GameObject obj) {
		obj.moveTo(new Point2D(x + width, obj.getY()));
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
