package com.cw.model.world;

import com.cw.utility.world.Director;
import com.cw.utility.world.GamePanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;


/**
 * @author:xueshanChen
 * @title:World
 * @description:define the worlds
 * @version: v1.0
 */

public class World {
    public static final String WORLD1 = "/world/World1.txt";
    public static final String WORLD2 = "/world/World2.txt";
    public static final String WORLD3 = "/world/World3.txt";
    public static final String RANK1 = "/world/rank.csv";
    public static final String RANK2 = "/world/rank2.csv";
    public static final String RANK3 = "/world/rank3.csv";
    //the file store the rank of current level
    private String rankTableFile = RANK1;
    private String thisWorld = WORLD1;
    private Label scoreLabel;
    private int score = 0;
    private GamePanel gamePanel;

    /**
     * constructor
     */
    public World(){

        scoreLabel = new Label();
        scoreLabel.setLayoutX(Director.UNIT_SIZE*35);
        scoreLabel.setLayoutY(Director.UNIT_SIZE*2);

    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void initPanel(){
        gamePanel = new GamePanel(this);
    }

    /**
     * initial the world
     * @param stage stage
     */
    public void init(Stage stage){
        initPanel();
        AnchorPane anchorPane =new AnchorPane();
        gamePanel.repaint(gamePanel.getCanvas().getGraphicsContext2D());
        anchorPane.getChildren().add(gamePanel.getCanvas());
        anchorPane.getChildren().add(scoreLabel);
        stage.setScene(new Scene(anchorPane));
        stage.setWidth(Director.WIDTH*Director.UNIT_SIZE + 15);
        stage.setHeight(Director.HEIGHT*Director.UNIT_SIZE + 38);
    }

    public String getRankTableFile() {
        return rankTableFile;
    }

    public void setRankTableFile(String rankTableFile) {
        this.rankTableFile = rankTableFile;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getThisWorld() {
        return thisWorld;
    }

    public void setThisWorld(String thisWorld) {
        this.thisWorld = thisWorld;
    }
    public void displayScore(){
//        scoreLabel.setTextFill(Color.cyan);
        scoreLabel.setFont(new Font(15));
        scoreLabel.setText("SCORE:"+Director.getInstance().getScore());
    }



}
