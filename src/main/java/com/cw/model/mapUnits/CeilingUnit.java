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
 * @title:CeilingUnit
 * @description:The CeilingUnit class creates ceiling units to be used for the world.
 *   			A ceiling unit is a unit shaped like a square that is treated as a ceiling, with collision on all four sides.
 *   			The ceiling collides with any kind of game object.
 *   			Even if a game object is on top of a ceiling, the game object will be pushed down.
 * @version: v1.0
 */

public class CeilingUnit extends GameObject {

	public CeilingUnit(InteractableWorld world, int colNum, int rowNum) {
		super(world, colNum, rowNum, Director.UNIT_SIZE, Director.UNIT_SIZE);
	}

	public void collideWith(GameObject obj) {
		if (this.overlaps(obj)) {
			moveBelowUnit(obj);
			obj.collideWithCeiling();
		}
	}

	@Override
	public void paint(GraphicsContext graphicsContext) {
		image = ImageManagement.unitImage;
		super.paint(graphicsContext);
	}

	void moveBelowUnit(GameObject obj) {
		obj.moveTo(new Point2D(obj.getX(), y + height));
	}

	@Override
	public void collideWithFloor() {
		// Nothing happens
	}

	@Override
	public void collideWithCeiling() {
		// Nothing happens
	}

	@Override
	public void collideWithWall() {
		// Nothing happens
	}
}
