package com.cw.model.gameObject;

import com.cw.model.mapUnits.CeilingUnit;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.model.mapUnits.WallUnit;
import com.cw.utility.ImageManagement;
import com.cw.utility.Sound;
import com.cw.utility.world.Director;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author:xueshanChen
 * @title:Enemy
 * @description:An Enemy is a non-controllable main.GameObject that kills the main.Hero whenever it or its projectile comes in contact.
 * Enemies are able to be bubbled and free themselves from these bubbles after a period of time.
 * Enemies change direction at random intervals, when hitting a wall, and when hitting the main.Hero's shield.
 * Enemies jump at random intervals as well.
 * @version: v1.0
 */
public class Enemy extends GameObject {
	private static final int WIDTH = Director.UNIT_SIZE + 10;
	private static final int HEIGHT = Director.UNIT_SIZE + 10;
	private static final int JUMP_SPEED = 20;
	private static final int TERMINAL_VELOCITY_X = 4;
	private static final int BUBBLED_FRAMES = 300;
	private static final double CHANGE_MOVEMENT_CHANCE = 0.01;

	boolean isBubbled;
	int timer;
	int pointValue;
	private boolean turningAwayFromShield;
	private int turningAwayCount;
	private boolean isOnAPlatform;
	private double jumpSpeed;
	
	public Enemy(InteractableWorld world, int colNum, int rowNum) {
		//initializes enemy
		super(world, colNum, rowNum, WIDTH, HEIGHT);
		isOnAPlatform = false;
		jumpSpeed = JUMP_SPEED;
		terminal_xVelocity = TERMINAL_VELOCITY_X;
		
		xAccel = 1.5;
		direction = 1;
		if (Math.random() < 0.5) {
			reverseDirection();
		}
		
		isBubbled = false;
		timer = BUBBLED_FRAMES;
		pointValue = 150;
		turningAwayFromShield = false;
		turningAwayCount = 10;
	}

	@Override
	public void paint(GraphicsContext graphicsContext) {
		image = ImageManagement.enemyImage.get(imageDirection.toString());
		if (isBubbled){
			image = ImageManagement.enemyImage.get(imageDirection+"Shielding");
		}
		super.paint(graphicsContext);
	}

	@Override
	public void collideWithFloor() {
		//handles floor collision values
		yVelocity = 0;
		if (!isOnAPlatform) {
			isOnAPlatform = true;
		}
	}

	@Override
	public void collideWithCeiling() {
		//handles ceiling collision values
		yVelocity = 0;
	}

	@Override
	public void update() {
		//updates enemy, handling movement
		super.update();
		if (isBubbled) {
			timer -= 1;
			if (timer <= 0) {
				isBubbled = false;
				timer = BUBBLED_FRAMES;
				xAccel = 1.5;
				direction = 1;
				this.imageDirection();
				if (Math.random() < 0.5) {
					reverseDirection();
				}
				yAccel = GameObject.GRAVITY;
			}
		} else {
			x +=  xVelocity*direction;
			if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
				jump();
			}
			if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
				reverseDirection();
			}
		}
	}

	private void jump() {
		//handles jumping
		if (isOnAPlatform) {
			y -= 1;
			yVelocity = -jumpSpeed;
			isOnAPlatform = false;
		}
	}

	private void shootProjectile() {
		// Nothing happens
	}
	
	public void collideWithProjectile() {
		//handles what to do if hit with a projectile by the hero
		if (!isBubbled) {
			Sound.playSound(Sound.BUBBLED);
			isBubbled = true;
			yVelocity = 0;
			xAccel = 0;
			yAccel = -0.1;
		}
	}
	
	public void collideWithWall() {
		//handles what to do on collision with a wall
		reverseDirection();
	}
	
	void die() {
		//handles what to do on death
		interactableWorld.addFruit(new Fruit(score,x, y, interactableWorld));
		markToRemove();
	}

	public void collideWith(Hero hero) {
		//handles collision with hero and what to do
		if (this.overlaps(hero)) {
			if (!isBubbled) {
				hero.collideWithMook();
				if (hero.getShielding() && !turningAwayFromShield) {
					turningAwayFromShield = true;
					reverseDirection();
				}
			}
			else if (!canRemove){
				Sound.playSound(Sound.POP);
				die();
			}
		}
		if (turningAwayFromShield) {
			if (turningAwayCount <= 0) {
				turningAwayCount = 10;
				turningAwayFromShield = false;
			}
			turningAwayCount -= 1;
		}
	}

	public void collideWith(CeilingUnit unit) {
		//handles unit collision
		if (this.overlaps(unit)) {
			if (isBubbled) {
				yVelocity = 0;
				yAccel = 0;
			}
		}
	}

	public void collideWith(FloorUnit floorUnit) {
		//handles unit collision
		if (this.overlaps(floorUnit)) {
			if (isBubbled) {
				yVelocity = 0;
				yAccel = 0;
			}
		}
	}

	public void collideWith(WallUnit wallUnit) {
		//handles unit collision
		if (this.overlaps(wallUnit)) {
			if (isBubbled) {
				yVelocity = 0;
				yAccel = 0;
			}
		}
	}
}

