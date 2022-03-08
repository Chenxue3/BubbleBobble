package com.cw.utility.world;


import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.factory.*;
import com.cw.model.world.World;
import com.cw.model.gameObject.*;
import com.cw.model.mapUnits.CeilingUnit;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.model.mapUnits.WallUnit;
import com.cw.view.Rank;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;


import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author:xueshanChen
 * @title:InteractableWorld
 * @description:InteractableWorld handles all of the game's operations
 * @version: v1.0
 */

public class InteractableWorld {
    private Hero hero;
    private CeilingUnit ceilingUnit;
    private FloorUnit floorUnit;
    private WallUnit wallUnit;
    private World world ;
    private ArrayList<CeilingUnit> ceilingUnits;
    private ArrayList<FloorUnit> floorUnits;
    private ArrayList<WallUnit> wallUnits;
    private ArrayList<Hero> heroes;
    private ArrayList<Enemy> enemies;
    private ArrayList<HeroProjectile> heroProjectiles;
    private ArrayList<EnemyProjectile> enemyProjectiles;
    private ArrayList<Fruit> fruits;
    private ArrayList<GameObject> toBeRemoved;
    private ArrayList<Bubble> bubbles;
    private ArrayList<Coin> coins;
    private Canvas canvas;
    private GameStore gameStore;
    private Background background = new Background(this);
    private GameFactory gameFactory;
    private GameObjectObserver gameObjectObserver;
    private AnimationTimer animationTimer;
    private ArrayList<Heart> heart;

    private boolean readyToReset;

    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * constructor
     * @param canvas to draw the game
     */
    public InteractableWorld(Canvas canvas, World world){
        this.world = world;
        gameObjectObserver = new GameObjectObserver(this);
        ceilingUnits = gameObjectObserver.getCeilingUnits();
        floorUnits = gameObjectObserver.getFloorUnits();
        wallUnits = gameObjectObserver.getWallUnits();
        heroes = gameObjectObserver.getHeroes();
        enemies = gameObjectObserver.getEnemies();
        heroProjectiles = gameObjectObserver.getHeroProjectiles();
        enemyProjectiles = gameObjectObserver.getEnemyProjectiles();
        fruits = gameObjectObserver.getFruits();
        toBeRemoved = gameObjectObserver.getToBeRemoved();
        bubbles = gameObjectObserver.getBubbles();
        coins = gameObjectObserver.getCoins();
        this.heart = new ArrayList<>();
        initHeart();
        this.gameStore = new GameStore();


        readyToReset = false;
        this.canvas = canvas;
    }

    private void initHeart(){
        this.heart.add(new Heart(this, 2,2, 40, 40));
        this.heart.add(new Heart(this, 4,2, 40, 40));
        this.heart.add(new Heart(this, 6,2, 40, 40));
    }

    /**
     * paint units
     * @param g GraphicsContext
     */
    public void paintUnits(GraphicsContext g){
       // g.clearRect(0,0,Director.UNIT_SIZE*Director.WIDTH,Director.UNIT_SIZE*Director.HEIGHT);
        background.paint(g);
        for (CeilingUnit ceilingUnit : ceilingUnits) {
            ceilingUnit.paint(g);
        }
        for (FloorUnit floorUnit : floorUnits) {
            floorUnit.paint(g);
        }
        for (WallUnit wallUnit : wallUnits) {
            wallUnit.paint(g);
        }

        for (Heart heart1 : heart) {
            heart1.paint(g);
        }
    }

    public void paintMoveable(GraphicsContext g){
        for (Hero hero : heroes) {
            hero.paint(g);
        }
        for (Enemy enemy : enemies) {
            enemy.paint(g);
        }
        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            enemyProjectile.paint(g);
        }
        for (HeroProjectile heroProjectile : heroProjectiles) {
            heroProjectile.paint(g);
        }
        for (Fruit fruit : fruits) {
            fruit.paint(g);
        }
        for (Bubble bubble : bubbles) {
            bubble.paint(g);
        }
        for(Coin coin: coins){
            coin.paint(g);
        }
    }

    /**
     * paint everything
     * @param g
     */
    protected void paintComponent(GraphicsContext g) {
        g.clearRect(0,0,Director.UNIT_SIZE*Director.WIDTH,Director.UNIT_SIZE*Director.HEIGHT);

        paintUnits(g);
        paintMoveable(g);

    }

    /**
     * update the position
     */
    void updatePosition() {
        if(isEnd()){
            animationTimer.stop();
            Director.getInstance().gameOver();
            Director.getInstance().writeScore("unknown");
            //if it is the highest score
            if (Rank.isHighest(Director.getInstance().getScore())){
                Director.getInstance().highScore();
            }
            getUserName();
        }
        world.setScore(heroes.get(0).score);
        world.displayScore();
        gameObjectObserver.updatePosition();
        // Removing...
        for (GameObject obj : toBeRemoved) {
            remove(obj);
        }
        toBeRemoved.removeAll(toBeRemoved);
        if (readyToReset){
            animationTimer.stop();
            animationTimer = null;
            if (this.heart.size() > 0) {
                this.heart.remove(this.heart.size() - 1);
            }

            if(this.heart.size() <= 0) {
                Director.getInstance().gameOver();
                getUserName();
                if (Rank.isHighest(Director.getInstance().getScore())){
                    Director.getInstance().highScore();
                    getUserName();
                }
            } else {
                startGame();
                world.getGamePanel().repaint(canvas.getGraphicsContext2D());
            }
        }
    }

    /**
     * pop up an alert to get the user's name
     */
    private void getUserName() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                TextInputDialog dialog = new TextInputDialog("User Name:");
                dialog.setTitle("please input your username");
                dialog.setHeaderText("your name is");
                Optional<String> content = dialog.showAndWait();
                String name;
                if (content.isPresent()) {
                    name =content.get();
                } else {
                    name = "unknown";
                }
                Director.getInstance().writeScore(name);
            }
        });
    }
//

    /**
     * get world
     * @return world
     */
    public World getWorld() {
        return world;
    }

    /**
     * check weather is end
     * @return true for end else false
     */
    public boolean isEnd(){
        return this.enemies.isEmpty() && this.fruits.isEmpty();
    }


    public void addHeroProjectile(HeroProjectile heroProjectile) {
        //adds a projectile to where necessary
        heroProjectiles.add(heroProjectile);
        gameObjectObserver.setHeroProjectiles(heroProjectiles);
    }

    public void addFruit(Fruit fruit) {
        //adds fruit on bubble pop
        fruits.add(fruit);
        gameObjectObserver.setFruits(fruits);
    }

    public void addBubble(Bubble bubble) {
        //adds special bubble
        bubbles.add(bubble);
        gameObjectObserver.setBubbles(bubbles);
    }
//
    void clearContents() {
        gameObjectObserver.clearContents();
    }

    public void remove(GameObject obj) {
        gameObjectObserver.remove(obj);
    }



    public void setAnimationTimer(AnimationTimer animationTimer) {
        this.animationTimer = animationTimer;
    }


    /**
     * set it to reset
     */
    public void markToReset() {
        //sets boolean to make sure the world is ready to be reset
        readyToReset = true;
    }


        /**
         * add objects
         */
        void  startGame () {
            InputStream input = this.getClass().getResourceAsStream(world.getThisWorld());
            System.out.println(world.getThisWorld());
            Scanner scanner = new Scanner(input);
            clearContents();
            System.out.println("obj init");
            generateObjList(scanner);
            paintUnits(canvas.getGraphicsContext2D());
            paintMoveable(canvas.getGraphicsContext2D());
            scanner.close();
            readyToReset = false;
        }

    /**
     * create objects
     * @param scanner
     */
    private void generateObjList(Scanner scanner) {
            gameObjectObserver.generateObjList(scanner);
    }


}


