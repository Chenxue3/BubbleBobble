package com.cw.model.gameObject;

import com.cw.model.GameFactory;
import com.cw.model.GameStore;
import com.cw.model.gameObject.factory.*;
import com.cw.model.mapUnits.CeilingUnit;
import com.cw.model.mapUnits.FloorUnit;
import com.cw.model.mapUnits.WallUnit;
import com.cw.model.world.World;
import com.cw.utility.world.Director;
import com.cw.utility.world.InteractableWorld;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author:xueshanChen
 * @className:GameObjectObserver
 * @description:GameObjectObserver
 * @version: v1.0
 */

public class GameObjectObserver {
    private Hero hero;
    private CeilingUnit ceilingUnit;
    private FloorUnit floorUnit;
    private WallUnit wallUnit;
    private World world = new World();
    private InteractableWorld interactableWorld;


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

    private GameStore gameStore;
    private GameFactory gameFactory;

    public GameObjectObserver(InteractableWorld interactableWorld){
        this.interactableWorld = interactableWorld;
        Background background = new Background(interactableWorld);
        this.world = world;

        //the lists store the game objects
        ceilingUnits = new ArrayList<CeilingUnit>();
        floorUnits = new ArrayList<FloorUnit>();
        wallUnits = new ArrayList<WallUnit>();
        heroes = new ArrayList<Hero>();
        enemies = new ArrayList<Enemy>();
        heroProjectiles = new ArrayList<HeroProjectile>();
        enemyProjectiles = new ArrayList<EnemyProjectile>();
        fruits = new ArrayList<Fruit>();
        toBeRemoved = new ArrayList<GameObject>();
        bubbles = new ArrayList<Bubble>();
        coins = new ArrayList<Coin>();

        //factory
        this.gameStore = new GameStore();
        new HeroFactory(this.gameStore);
        new EnemyFactory(this.gameStore);
        new CeilingUnitFactory(this.gameStore);
        new FloorUnitFactory(this.gameStore);
        new WallUnitFactory(this.gameStore);
        new CoinFactory(this.gameStore);

    }
    public ArrayList<CeilingUnit> getCeilingUnits() {
        return ceilingUnits;
    }

    public void setCeilingUnits(ArrayList<CeilingUnit> ceilingUnits) {
        this.ceilingUnits = ceilingUnits;
    }

    public ArrayList<FloorUnit> getFloorUnits() {
        return floorUnits;
    }

    public void setFloorUnits(ArrayList<FloorUnit> floorUnits) {
        this.floorUnits = floorUnits;
    }

    public ArrayList<WallUnit> getWallUnits() {
        return wallUnits;
    }

    public void setWallUnits(ArrayList<WallUnit> wallUnits) {
        this.wallUnits = wallUnits;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<HeroProjectile> getHeroProjectiles() {
        return heroProjectiles;
    }

    public void setHeroProjectiles(ArrayList<HeroProjectile> heroProjectiles) {
        this.heroProjectiles = heroProjectiles;
    }

    public ArrayList<EnemyProjectile> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    public void setEnemyProjectiles(ArrayList<EnemyProjectile> enemyProjectiles) {
        this.enemyProjectiles = enemyProjectiles;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public ArrayList<GameObject> getToBeRemoved() {
        return toBeRemoved;
    }

    public void setToBeRemoved(ArrayList<GameObject> toBeRemoved) {
        this.toBeRemoved = toBeRemoved;
    }

    public ArrayList<Bubble> getBubbles() {
        return bubbles;
    }

    public void setBubbles(ArrayList<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Coin> coins) {
        this.coins = coins;
    }



    public void updatePosition() {
        for (Hero hero : heroes) {
            hero.update();
        }
        for (Enemy enemy : enemies) {
            enemy.update();
            if (enemy.canRemove) {
                toBeRemoved.add(enemy);
            }
        }
        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            enemyProjectile.update();
            if (enemyProjectile.canRemove) {
                toBeRemoved.add(enemyProjectile);
            }
        }
        for (HeroProjectile heroProjectile : heroProjectiles) {
            heroProjectile.update();
            if (heroProjectile.canRemove) {
                toBeRemoved.add(heroProjectile);
            }
        }
        for (Fruit fruit : fruits) {
            fruit.update();
            if (fruit.canRemove) {
                toBeRemoved.add(fruit);
            }
        }
        for (Bubble bubble : bubbles) {
            //charge = 0;
            bubble.update();
            if (bubble.canRemove) {
                toBeRemoved.add(bubble);
            }
        }

        // Colliding...
        colliding();
        // Enemies initiate collisions with Heroes
        for (Enemy enemy : enemies) {
            for (Hero hero : heroes) {
                enemy.collideWith(hero);
            }
        }
        // HeroProjectiles initiate collisions with Heroes and Enemies
        heroProjectileCollisions();
        // Fruits intiate collisions with Heroes
        for (Fruit fruit : fruits) {
            for (Hero hero : heroes) {
                fruit.collideWith(hero);
            }
        }
        for (Bubble bubble : bubbles) {
            for (Enemy enemy : enemies) {
                bubble.collideWith(enemy);
            }
        }

    }

    private void heroProjectileCollisions() {
        for (HeroProjectile heroProjectile : heroProjectiles) {
            for (Hero hero : heroes) {
                heroProjectile.collideWith(hero);
            }
            for (Enemy enemy : enemies) {
                heroProjectile.collideWith(enemy);
            }
        }
        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            for (Hero hero : heroes) {
                enemyProjectile.collideWith(hero);
            }
            for (Enemy enemy : enemies) {
                enemyProjectile.collideWith(enemy);
            }
        }
    }

    private void colliding() {
        // Units initiate collisions with Heroes, Enemies, and Fruits
        for (CeilingUnit ceilingUnit : ceilingUnits) {
            for (Hero hero : heroes) {
                ceilingUnit.collideWith(hero);
            }
            for (Enemy enemy : enemies) {
                ceilingUnit.collideWith(enemy);
                enemy.collideWith(ceilingUnit);
            }
            for (Fruit fruit : fruits) {
                ceilingUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                ceilingUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                ceilingUnit.collideWith(heroProjectile);
            }
        }
        for (FloorUnit floorUnit : floorUnits) {
            for (Hero hero : heroes) {
                floorUnit.collideWith(hero);
            }
            for (Enemy enemy : enemies) {
                floorUnit.collideWith(enemy);
                enemy.collideWith(floorUnit);
            }
            for (Fruit fruit : fruits) {
                floorUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                floorUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                floorUnit.collideWith(heroProjectile);
            }
        }
        for (WallUnit wallUnit : wallUnits) {
            for (Hero hero : heroes) {
                wallUnit.collideWith(hero);
            }
            for (Enemy enemy : enemies) {
                wallUnit.collideWith(enemy);
                enemy.collideWith(wallUnit);
            }
            for (Fruit fruit : fruits) {
                wallUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                wallUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                wallUnit.collideWith(heroProjectile);
            }
        }
    }

    /**
     * add ceiling unit
     * @param ceilingUnit ceiling unit
     */
    public void addCeilingUnit(CeilingUnit ceilingUnit) {
        ceilingUnits.add(ceilingUnit);
    }

    public void addFloorUnit(FloorUnit floorUnit) {
        floorUnits.add(floorUnit);
    }

    public void addWallUnit(WallUnit wallUnit) {
        wallUnits.add(wallUnit);
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public void addHero(Hero hero){
        //adds a hero to the map
        heroes.add(hero);
    }
    void addEnemy(Enemy enemy) {
        //adds a mook to the map
        enemies.add(enemy);
    }

    public void addHeroProjectile(HeroProjectile heroProjectile) {
        //adds a projectile to where necessary
        heroProjectiles.add(heroProjectile);
    }

    public void addFruit(Fruit fruit) {
        //adds fruit on bubble pop
        fruits.add(fruit);
    }

    public void addBubble(Bubble bubble) {
        //adds special bubble
        bubbles.add(bubble);
    }
    public void generateObjList(Scanner scanner) {
        for (int row = 0; row < Director.HEIGHT; row++) {
            String currentLine = scanner.next();
            for (int col = 0; col < Director.WIDTH; col++) {
                if (currentLine.charAt(col) == '*') {
                    addFloorUnit((FloorUnit) gameStore.create("FloorUnit",interactableWorld, col, row));
                } else if (currentLine.charAt(col) == 'H') {
                    addHero((Hero) gameStore.create("Hero",interactableWorld, col, row));
                } else if (currentLine.charAt(col) == '|') {
                    addWallUnit((WallUnit) gameStore.create("WallUnit",interactableWorld, col, row));
                } else if (currentLine.charAt(col) == '_') {
                    addCeilingUnit((CeilingUnit) gameStore.create("CeilingUnit",interactableWorld, col, row));
                } else if (currentLine.charAt(col) == 'M') {
                    addEnemy((Enemy) gameStore.create("Enemy",interactableWorld, col, row));
                }
                else if(currentLine.charAt(col) == 'C'){
                    addCoin((Coin) gameStore.create("Coin",interactableWorld,col,row));
                }
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public void clearContents() {
        //clears everything from the screen
        ceilingUnits.removeAll(ceilingUnits);
        floorUnits.removeAll(floorUnits);
        wallUnits.removeAll(wallUnits);
        heroes.removeAll(heroes);
        enemies.removeAll(enemies);
        enemyProjectiles.removeAll(enemyProjectiles);
        heroProjectiles.removeAll(heroProjectiles);
        fruits.removeAll(fruits);
        coins.removeAll(coins);
    }

    public void remove(GameObject obj) {
        //removes a single object from the screen
        ceilingUnits.remove(obj);
        floorUnits.remove(obj);
        wallUnits.remove(obj);
        heroes.remove(obj);
        enemies.remove(obj);
        enemyProjectiles.remove(obj);
        heroProjectiles.remove(obj);
        fruits.remove(obj);
        bubbles.remove(obj);
        coins.remove(obj);
    }
}
