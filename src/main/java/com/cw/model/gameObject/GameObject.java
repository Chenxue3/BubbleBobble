package com.cw.model.gameObject;

import com.cw.utility.Direction;
import com.cw.utility.world.Director;
import com.cw.utility.world.InteractableWorld;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.geom.Rectangle2D;


/**
 * @author：xueshanChen
 * @title:GameObject
 * @description:The class deal with all the objects
 * @version: v1.0
 */

public abstract class GameObject {
    private static final double STATIC_FRICTION = 0.1;
    protected static final int GRAVITY = 1;
    private static final int TERMINAL_FALL_SPEED = 20;
    public int score;
    public InteractableWorld interactableWorld;
    public int x, y;
    public int width, height;

    public double xVelocity, yVelocity;
    public double xAccel, yAccel;
    public int terminal_xVelocity, terminal_yVelocity;

    public boolean canRemove;
    public int direction;
    public Direction imageDirection;
    protected Image image;

    /**
     * constructor
     * @param interactableWorld the interacble world
     * @param colNum col in the world
     * @param rowNum row in the world
     * @param width width
     * @param height height
     */
    public GameObject(InteractableWorld interactableWorld, int colNum, int rowNum, int width, int height) {
        this.interactableWorld = interactableWorld;
        x = colNum * Director.UNIT_SIZE;
        y = rowNum * Director.UNIT_SIZE;
        this.width = width;
        this.height = height;

        xVelocity = 0;
        yVelocity = 0;
        xAccel = 0;
        yAccel = GRAVITY;
        terminal_xVelocity = 0;
        terminal_yVelocity = TERMINAL_FALL_SPEED;
        canRemove = false;
        direction = -1;
        imageDirection = this.imageDirection();
    }

    /**
     * initializes the game object
     * @param x the x
     * @param y the y
     * @param interactableWorld the interacble world
     * @param width width
     * @param height height
     */
    public GameObject(int x, int y, int width, int height, InteractableWorld interactableWorld) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.interactableWorld = interactableWorld;

        xVelocity = 0;
        yVelocity = 0;
        xAccel = 0;
        yAccel = GRAVITY;
        terminal_xVelocity = 0;
        terminal_yVelocity = TERMINAL_FALL_SPEED;
        canRemove = false;
        direction = -1;
        imageDirection = this.imageDirection();
    }


    public abstract void collideWithFloor();
    public abstract void collideWithCeiling();
    public abstract void collideWithWall();

    /**
     * general update method of every game object
     */
    public void update() {
        if (Math.abs(xVelocity) < terminal_xVelocity) {
            xVelocity += xAccel;
        }
        if (Math.abs(xVelocity) > STATIC_FRICTION) {
            if (xVelocity < 0) {
                xVelocity += 1;
            } else {
                xVelocity -= 1;
            }
            x += xVelocity;
        }

        if (yVelocity < terminal_yVelocity) {
            yVelocity += yAccel;
        }
        y += yVelocity;

    }
    /**
     * draw the object in the panel
     * @param graphicsContext the content of this object
     */
    public void paint(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, x, y, width, height);
    }

    /**
     * reverses game object's direction
     */
    protected void reverseDirection() {
        xAccel *= -1;
        direction *= -1;
        imageDirection();
    }

    /**
     * returns x coordinate of upper left corner
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * returns y coordinate of upper left corner
     * @return y
     */
    public double getY() {
        //returns y coordinate of upper left corner
        return y;
    }

    /**
     * returns width
     * @return width
     */
    public double getWidth() {
        //returns width
        return width;
    }

    /**
     * returns height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * sets whether something can be removed
     */
    protected void markToRemove() {
        canRemove = true;
    }

    /**
     * sets hitBox for each game object
     * @return hitBox
     */
    public Rectangle2D.Double getHitBox(){
        return new Rectangle2D.Double(x, y, width, height);
    }

    /**
     * checks if two objects overlap or collide
     * @param obj game object
     * @return hitBox
     */
    protected boolean overlaps(GameObject obj) {
        return getHitBox().intersects(obj.getHitBox());
    }

    /**
     * moves object to a point
     * @param point
     */
    public void moveTo(Point2D point) {
        x = (int) point.getX();
        y = (int) point.getY();
    }

    /**
     * set imageDirection
     * @return imageDirection
     */
    public Direction imageDirection(){
        if(direction == 1){
            imageDirection = Direction.right;
        }
        else {
            imageDirection = Direction.left;
        }
        return imageDirection;
    }



}
