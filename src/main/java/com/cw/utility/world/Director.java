package com.cw.utility.world;

//import com.cw.model.world.WordLevelFactory;
import com.cw.model.world.World;
import com.cw.view.Rank;
import com.cw.view.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author:xueshanChen
 * @title:Director
 * @description:Using singleton design pattern, because every time run this project , only one game should run
 * This class follow the signal responsibility of classes rather than methods, which can reduce the cost.
 * @version: v1.0
 */

public class Director {
    /**
     * Change the width and the height of the window from private to public
     * they are static so can be accessed by other modules.
     */
    public static final int WIDTH = 40, HEIGHT = 34;
    public static final int UNIT_SIZE = 22;

    private World world;
    private GamePanel gamePanel;
    private int life = 3;

    private int score = 0;

    /**
     * add score
     * @param score score
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * set score to 0
     */
    public void clearScore(){
        this.score = 0;
    }

    /**
     * get score
     * @return score
     */
    public int getScore() {
        return score;
    }

    private Stage stage;
    private static Director instance = new Director();


    /**
     * this way to implement the Singleton Design Pattern may waste of the space, but it is thread-safety
     *
     * @return the instance of this Director Class
     */
    public static Director getInstance() {
        return instance;
    }



    /**
     * init the stage
     * @param stage
     */
    public void init(Stage stage) {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE);
        stage.setTitle("BubbleBobble");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/static/img/iconTitle.png")));
        stage.setResizable(false);
        this.stage = stage;
        stage.setWidth(WIDTH * UNIT_SIZE);
        stage.setHeight(HEIGHT * UNIT_SIZE);
        stage.setScene(scene);

        goIndexPage();
        stage.show();
    }

    /**
     * show the index page
     */
    public void goIndexPage() {
        Index.start(stage);
    }

    public void gameOver() {
        GameOver.GameOver(stage);
    }

    /**
     * show the rank
     */
    public void goRank(){
        Rank.rankPage(stage);
    }

    /**
     * show highest score
     */
    public void highScore(){
        HighScore.HighScore(stage);
    }

    /**
     * show die page
     */
    public void die(){

    }

    /**
     * go to help page
     */
    public void help(){
        Help.Help(stage);
    }

    /**
     * generate the game stage
     */
    public void gameStart() {
        world = worldSetting(Setting.getLevel());
        System.out.println(world.getThisWorld()+"---"+world.getRankTableFile());
        world.init(stage);
    }

    /**
     * set world into levels
     * @param level the level
     * @return
     */
    public World worldSetting(String level) {
        World world = new World();
        if(level.equals("hard")){
            world.setRankTableFile(World.RANK3);
            world.setThisWorld(World.WORLD3);
        }
        else if(level.equals("easy")){
            world.setRankTableFile(World.RANK1);
            world.setThisWorld(World.WORLD1);
        }
        else if(level.equals("middle")){
            world.setRankTableFile(World.RANK2);
            world.setThisWorld(World.WORLD2);
        }
        return world;
    }


    public void writeScore(String name) {
        Rank rank = new Rank();
        rank.writeScore(name);
    }

    public void gameSetting() throws IOException {
        Setting.settings(stage);
    }
}
