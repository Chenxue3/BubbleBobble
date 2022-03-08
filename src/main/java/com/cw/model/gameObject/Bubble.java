package com.cw.model.gameObject;

import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author:xueshanChen
 * @title:Bubble
 * @description: The main.Bubble class handles everything with the main.Hero's special ability, named the bubble.
 * It begins at the hero, and grows covering the whole screen.
 * Once it collides with an enemy, that enemy is bubbled.
 * @version: v1.0
 */
public class Bubble extends GameObject {
	private int accel;
	
	public Bubble(InteractableWorld world, int x, int y) {
		super(x, y, 0, 0, world);
		accel = 1;
	}

	@Override
	public void update() {
		if (width >= 2500) {
			markToRemove();
		}
		x -= accel / 2;
		y -= accel / 2;
		width += accel;
		height += accel;
		accel += 1;
	}


	@Override
	public void paint(GraphicsContext graphicsContext) {
		image = new Image(Bubble.class.getResource("/static/img/bubs/bubble.png").toString());
		super.paint(graphicsContext);
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
	
	public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy)) {
			enemy.collideWithProjectile();
		}
	}

}
