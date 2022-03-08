package com.cw.model.gameObject;

import com.cw.utility.Direction;
import com.cw.utility.ImageManagement;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * @author:xueshanChen
 * @title:EnemyProjectile
 * @description:The HeroProjectile class handles the specificities with the projectile being shot from a hero.
 * 				For example, the hero's projectile has a different color than the projectile of an enemy.
 * 				It also can only hurt an enemy.
 * @version: v1.0
 */
public class HeroProjectile extends GameObject {
	private static final int SIZE = 20;
	private static final int SPEED = 15;
	private static final int TERMINAL_VELOCITY_Y = 5;

	private boolean isActive;
	private int activeFrames;
	private int timer;

	public HeroProjectile(InteractableWorld world, int x, int y, int direction) {
		super(x, y, SIZE, SIZE, world);
		this.direction = direction;

		xVelocity = SPEED;
		yAccel = 0;

		isActive = true;
		activeFrames = 35;
		timer = activeFrames;
	}

	/**
	 * draw the object in the panel
	 *
	 * @param graphicsContext the content of this object
	 */
	@Override
	public void paint(GraphicsContext graphicsContext) {
		imageDirection = imageDirection();
		image = new Image("/static/img/bubs/bubble.png");
		super.paint(graphicsContext);
	}

	@Override
	public void update() {
		y += yVelocity;
		x += xVelocity * direction;
		updateVelocity();

		if(y < 25) {
			y = 25;
		}

		if (timer < 0) {
			isActive = false;
		}

		if (timer < -200) {
			markToRemove();
		}
		timer -= 1;
	}

	private void updateVelocity() {
		if (xVelocity > 0) {
			xVelocity -= 0.25;
		} else {
			xVelocity = 0;
		}

		if (Math.abs(yVelocity) < TERMINAL_VELOCITY_Y && !isActive) {
			yVelocity -= 0.1;
		}
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

	@Override
	public Direction imageDirection() {
		return super.imageDirection();
	}

	public void collideWith(Hero hero) {
		// Nothing happens
	}

	public void collideWith(Enemy enemy) {
		if (this.overlaps(enemy) && isActive) {
			enemy.collideWithProjectile();
		}
	}
}
