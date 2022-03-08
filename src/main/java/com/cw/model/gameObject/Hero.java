package com.cw.model.gameObject;

import com.cw.utility.ImageManagement;
import com.cw.utility.Sound;
import com.cw.utility.world.InteractableWorld;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;


/**
 * @author：xueshanChen
 * @title:Hero
 * @description:the class of hero
 * A Hero is a main.GameObject that is controllable by the player.
 * Of all the main.GameObject, only Hero has KeyBindings.
 * Hero can shoot HeroProjectiles, shield from attacks, trigger a special attack and
 * collect Fruits for points.
 * @version: v1.0
 */
public class Hero extends GameObject{
    private static final int JUMP_SPEED = 22;
    private static final int TERMINAL_VELOCITY_X = 6;
    private static final int HERO_SIZE = 30;
    private static final int WALK = 3;
    private static final int RUN = 5;
    private static final double RUN_ACCEL = 16;
    private static final int SHIELD_TIME = 100;

    private boolean isShielding;
    private int shieldTimer;
    private boolean isStunned;
    private int stunTimer;
    private int shootDelay;
    private boolean readyToCharge;
    private boolean isOnAPlatform;
    private double jumpSpeed;
    private Canvas canvas;

    public Hero(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, HERO_SIZE, HERO_SIZE);
        System.out.println("image direct:"+imageDirection);
        isOnAPlatform = false;

        terminal_xVelocity = TERMINAL_VELOCITY_X;
        jumpSpeed = JUMP_SPEED;

        isShielding = false;
        shieldTimer = SHIELD_TIME;
        isStunned = false;
        stunTimer = 250;
        shootDelay = 0;
        readyToCharge = false;

        //keyboard listener
        canvas = this.interactableWorld.getCanvas();
        move();
        imageDirection = imageDirection();
    }

    @Override
    public void paint(GraphicsContext graphicsContext) {
        image = ImageManagement.heroImageMap.get(imageDirection.toString());
        super.paint(graphicsContext);
    }

    public void hitEnemy(int score){
        this.score += score;
    }



    public void move() {
        canvas.requestFocus();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> keyPress(e));
        canvas.setOnKeyReleased(e -> releaseKey(e));
    }

    /**
     * define the movement when the key pressed
     * @param keyEvent key event
     */
    private void keyPress(KeyEvent keyEvent){
        switch (keyEvent.getCode()){
            case RIGHT:
                if (!isShielding && !isStunned) {
                    xAccel = RUN_ACCEL;
                    direction = 1;
                    imageDirection();
                    System.out.println("press right");
                }
                break;
            case LEFT:
                if (!isShielding && !isStunned) {
                    xAccel = -RUN_ACCEL;
                    direction = -1;
                    imageDirection();
                    System.out.println("press left");
                }
                break;
            case UP:
                if (!isShielding && !isStunned) {
                    System.out.println("up press");
                    jump();
                    Sound.playSound(Sound.JUMP_SOUND);
                }
                break;
            case SPACE:
                terminal_xVelocity = RUN;
                break;
            case E:
                if (!isShielding && !isStunned) {
                    shootDelay -= 1;
                    if (shootDelay <= 0) {
                        shootProjectile();
                        shootDelay = 10;
                    }
                }
                break;
            case W:
                if (readyToCharge) {
                    readyToCharge = true;
                    interactableWorld.addBubble(new Bubble(interactableWorld, x, y));
                    Sound.playSound(Sound.EXPLODE_SONG);
                    readyToCharge = false;
                }
                break;
            case Q:
                if (!isStunned) {
                    xVelocity = 0;
                    xAccel = 0;
                    isShielding = true;
                }
        }
    }

    /**
     * when release key
     * @param keyEvent key event
     */
    private void releaseKey(KeyEvent keyEvent){
        switch (keyEvent.getCode()){
            case RIGHT:
                xAccel = 0;
                break;
            case LEFT:
                xAccel = 0;
                break;
            case SPACE:
                terminal_xVelocity = WALK;
                break;
            case E:
                shootDelay = 0;
                break;
            case Q:
                isShielding = false;
        }
    }

    /**
     * shout
     */
    public void shootProjectile() {
        //makes hero shoot projectile
        Sound.playSound(Sound.SHOT_SOUND);
        interactableWorld.addHeroProjectile(new HeroProjectile(interactableWorld, x, y, direction));
    }

    /**
     * collide With Mook
     */
    void collideWithMook() {
        //handles colliding with a mook
        if (!isShielding) {
            die();
        }
    }

    /**
     * hero jump
     */
    private void jump() {
        //handles jumping
        if (isOnAPlatform) {
            y -= 1;
            yVelocity = -jumpSpeed;
            isOnAPlatform = false;
        }
    }

    @Override
    public void collideWithWall() {
        xVelocity = 0;
    }

    public void die() {
        Sound.playSound(Sound.DEATH);
        interactableWorld.markToReset();
    }

    public void collideWithProjectile() {
        //handles collision with projectiles
        if (!isShielding) {
            die();
        }
    }

    /**
     *         //updates position of hero, according to many variables
     *         //including whether or not the hero is shielding,
     *         //or if the hero is stunned
     */
    @Override
    public void update() {
        super.update();
        if (isShielding) {
            shieldTimer -= 1;
            if (shieldTimer <= 0) {
                shieldTimer = 0;
                isShielding = false;
                isStunned = true;
            }
        } else {
            if (shieldTimer < SHIELD_TIME && !isStunned) {
                shieldTimer += 1;
            }
        }
        if (isStunned) {
            stunTimer -= 1;
            if (stunTimer <= 0) {
                isStunned = false;
                stunTimer = 250;
                shieldTimer = SHIELD_TIME;
            }
        }
    }

    @Override
    public void collideWithFloor() {
        //handles collision with floor
        yVelocity = 0;
        if (!isOnAPlatform) {
            isOnAPlatform = true;
            Sound.playSound(Sound.LAND);
        }
    }

    @Override	public void collideWithCeiling() {

    }

    /**
     * //gets whether or not the hero is shielding on this frame and returns it
     * @return isShielding
     */
    public boolean getShielding() {
        return isShielding;
    }

}
