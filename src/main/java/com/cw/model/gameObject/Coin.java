package com.cw.model.gameObject;

import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author:xueshanChen
 * @title:CoinFactory
 * @description:the class of Coins
 * @version: v1.0
 */
public class Coin extends GameObject {
	private static final int SIZE = 15;
	private static final int TERMINAL_VELOCITY_Y = 10;

	private boolean readyToCollect;

	public Coin(InteractableWorld world,int x, int y) {
		//initializes fruit
		super(x, y, SIZE, SIZE, world);
		terminal_yVelocity = TERMINAL_VELOCITY_Y;
		readyToCollect = false;
	}

	@Override
	public void paint(GraphicsContext graphicsContext) {
		super.paint(graphicsContext);
	}

	public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {
			readyToCollect = false;
			markToRemove();
		}
	}

	@Override
	public void collideWithFloor() {
		yVelocity = 0;
		if (!canRemove) {
			readyToCollect = true;
		}
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
