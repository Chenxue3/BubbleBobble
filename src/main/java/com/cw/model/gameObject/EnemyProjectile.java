package com.cw.model.gameObject;

import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * @author:xueshanChen
 * @title:EnemyProjectile
 * @description:The EnemyProjectile class handles the specificities with the projectile being shot from an enemy.
 *  		      For example, the enemy's projectile has a different color than the projectile of a hero.
 * 			      It also can only hurt a hero.
 * @version: v1.0
 */
public class EnemyProjectile extends GameObject {
	private static final int SIZE = 20;
	private static final int SPEED = 15;
	private static final int TERMINAL_VELOCITY_Y = 5;

	private boolean isActive;
	private int activeFrames;
	private int timer;

	public EnemyProjectile(InteractableWorld world, int x, int y, int direction) {
		super(x, y, SIZE, SIZE, world);
		this.direction = direction;

		xVelocity = SPEED;
		yAccel = 0;

		isActive = true;
		activeFrames = 20;
		timer = activeFrames;
	}

	@Override
	public void paint(GraphicsContext graphicsContext) {

		super.paint(graphicsContext);
		if (isActive) {
			graphicsContext.setFill(Color.RED);
		} else {
			graphicsContext.setFill(new Color(0, 102, 0, 40));
		}
		graphicsContext.fillOval(x, y, width, height);
		graphicsContext.setFill(Color.BLACK);
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
		// Nothing happen
	}

	@Override
	public void collideWithCeiling() {
		// Nothing happen
	}

	@Override
	public void collideWithWall() {
		// Nothing happen
	}

	public void collideWith(Hero hero) {
		if(this.overlaps(hero) && isActive) {
			hero.collideWithProjectile();
		}
	}

	public void collideWith(Enemy enemy) {
		//Nothing happens
	}
}
