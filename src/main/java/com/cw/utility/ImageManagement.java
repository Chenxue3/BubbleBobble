package com.cw.utility;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:xueshanChen
 * @title:ImageManagement
 * @description:deal with the image of each type of the roles
 * @version: v1.0
 */

public class ImageManagement {
    public static final Map<String, Image> heroImageMap = new HashMap<>();
    public static final Map<String, Image> enemyImage = new HashMap<>();
    public static final Map<String, Image> enemyBossImage = new HashMap<>();
    public static Image bgImage;
    public static Image unitImage;

    /**
     * store the corresponding images for the hero
     * using HashMap to store the images and their key values
     * resources come from the internet
     *
     * @param heroType  the selected type of hero
     */
    public static void imageStore(String heroType) {
        if ("Green".equals(heroType)) {
            //green
            heroImageMap.put("left", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub1Left.png").toString()));
            heroImageMap.put("right", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub1Right.png").toString()));
            heroImageMap.put("leftDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub1LeftDeath.png").toString()));
            heroImageMap.put("rightDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub1RightDeath.png").toString()));
        } else if ("Blue".equals(heroType)) {
            //blue
            heroImageMap.put("left", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub2Left.png").toString()));
            heroImageMap.put("right", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub2Right.png").toString()));
            heroImageMap.put("leftDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub2LeftDeath.png").toString()));
            heroImageMap.put("rightDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub2RightDeath.png").toString()));
        } else if ("Red".equals(heroType)) {
            //red
            heroImageMap.put("left", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub3Left.png").toString()));
            heroImageMap.put("right", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub3Right.png").toString()));
            heroImageMap.put("leftDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub3LeftDeath.png").toString()));
            heroImageMap.put("rightDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub3RightDeath.png").toString()));
        } else if ("Orange".equals(heroType)) {
            //orange
            heroImageMap.put("left", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub4Left.png").toString()));
            heroImageMap.put("right", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub4Right.png").toString()));
            heroImageMap.put("leftDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub4LeftDeath.png").toString()));
            heroImageMap.put("rightDeath", new Image(ImageManagement.class.getResource("/static/img/bubs/Bub4RightDeath.png").toString()));
        }
        else {
            System.out.println("nothing for hero");
        }
    }

    /**
     *store the image of the enemies
     */
    public static void enemyImgList(){
            enemyBossImage.put("left", new Image(ImageManagement.class.getResource("/static/img/bubs/BossEnemyLeft.png").toString()));
            enemyBossImage.put("right", new Image(ImageManagement.class.getResource("/static/img/bubs/BossEnemyRight.png").toString()));
            enemyImage.put("left", new Image(ImageManagement.class.getResource("/static/img/bubs/enemyLeft.png").toString()));
            enemyImage.put("right", new Image(ImageManagement.class.getResource("/static/img/bubs/enemyRight.png").toString()));
            enemyImage.put("rightShielding", new Image(ImageManagement.class.getResource("/static/img/bubs/enemyRightAttacked.png").toString()));
            enemyImage.put("leftShielding", new Image(ImageManagement.class.getResource("/static/img/bubs/enemyLeftAttacked.png").toString()));
    }

    /**
     * store the corresponding images for map
     * using HashMap to store the images and their key values
     * resources come from the internet
     *
     * @param scene the selected type of hero
     */
    public static void styleImageManagement(String scene) {
        if ("Hack".equals(scene)) {
            bgImage = new Image(ImageManagement.class.getResource("/static/img/bg/bgBlue.jpg").toString());
            unitImage=new Image(ImageManagement.class.getResource("/static/img/bg/BubbleBobbleWallBlue.png").toString());
        } else if ("Sweet".equals(scene)) {
            bgImage=new Image(ImageManagement.class.getResource("/static/img/bg/bgPink.jpg").toString());
            unitImage= new Image(ImageManagement.class.getResource("/static/img/bg/BubbleBobbleWallPink.png").toString());
        } else if ("Blue Sky".equals(scene)) {
            bgImage= new Image(("/static/img/bg/bgWhite.jpg"));
            unitImage= new Image(ImageManagement.class.getResource("/static/img/bg/BubbleBobbleWallWhite.png").toString());
        } else if ("Old Story".equals(scene)) {
            bgImage=new Image(("/static/img/bg/bgYellow.jpg"));
            unitImage= new Image(("/static/img/bg/BubbleBobbleWallYellow.png"));
        }
        else {
            System.out.println("noting for scene");
        }
    }

}
