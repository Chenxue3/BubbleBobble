package com.cw.utility.world;

import com.cw.model.world.World;
import com.cw.utility.Sound;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author:xueshanChen
 * @title:GamePanel
 * @description:where the entire game is constantly updated.
 * @version: v1.0
 */

public class GamePanel {
    public AnimationTimer animationTimer;
    InteractableWorld interactableWorld;
    private Canvas canvas;


    /**
     * constructor
     */
    public GamePanel(World world){
        canvas = new Canvas(Director.WIDTH * Director.UNIT_SIZE, Director.HEIGHT * Director.UNIT_SIZE);
        interactableWorld = new InteractableWorld(canvas,world);
        interactableWorld.startGame();
    }
    /**
     * @return canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    public void repaint(GraphicsContext graphicsContext){
        animationTimer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                interactableWorld.updatePosition();
                interactableWorld.paintComponent(graphicsContext);
            }
        };
        interactableWorld.setAnimationTimer(animationTimer);
        animationTimer.start();
        interactableWorld.updatePosition();
        graphicsContext.clearRect(0,0,Director.UNIT_SIZE*Director.WIDTH,Director.UNIT_SIZE*Director.HEIGHT);
    }

    /**
     * @param stage the stage
     */
    public void init(Stage stage) {
        AnchorPane root = new AnchorPane(canvas);
        stage.getScene().setRoot(root);
        repaint(canvas.getGraphicsContext2D());
    }

}
