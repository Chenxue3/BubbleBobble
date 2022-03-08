package com.cw.model.gameObject;

import com.cw.utility.Sound;
import com.cw.utility.world.Director;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 * @author:xueshanChen
 * @title:Fruit
 * @description: The Fruit class handles how the fruit is created and interacts with the hero.
 * The fruits are created after a bubble containing an enemy is popped.
 * @version: v1.0
 */
public class Fruit extends GameObject {
	private static final int SIZE = 15;
	private static final int TERMINAL_VELOCITY_Y = 10;
	private boolean readyToCollect;

	public Fruit(int score, int x, int y, InteractableWorld world) {
		//initializes fruit
		super(x, y, SIZE, SIZE, world);
		terminal_yVelocity = TERMINAL_VELOCITY_Y;
		readyToCollect = false;
		this.score = score;
	}

	@Override
	public void paint(GraphicsContext graphicsContext) {
		image = new Image(Fruit.class.getResource("/static/img/bubs/apple.gif").toString());
		super.paint(graphicsContext);
	}

	public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {
			Sound.playSound(Sound.FRUIT);
			readyToCollect = false;
			markToRemove();
			Director.getInstance().addScore(10);

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
