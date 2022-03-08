package com.cw.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.io.IOException;

/**
 * @author:xueshanChen
 * @title:Setting
 * @description:Game Setting
 * @version: v1.0
 */

public class Setting {
    public static String SCENE = "Old Story";
    public static String HERO_TYPE = "Red";
    public static String level = "easy";

    public static String getSCENE() {
        return SCENE;
    }

    public static void setSCENE(String SCENE) {
        Setting.SCENE = SCENE;
    }

    public static String getHeroType() {
        return HERO_TYPE;
    }

    public static void setHeroType(String heroType) {
        HERO_TYPE = heroType;
    }
    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        Setting.level = level;
    }

    public static void settings(Stage stage){
        try {
            Parent root= FXMLLoader.load(Setting.class.getResource("/layouts/Setting.fxml"));
            stage.getScene().setRoot(root);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
