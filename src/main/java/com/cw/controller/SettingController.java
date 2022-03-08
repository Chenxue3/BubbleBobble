package com.cw.controller;

import com.cw.utility.ImageManagement;
import com.cw.utility.Sound;
import com.cw.utility.world.Director;
import com.cw.view.Setting;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author:xueshanChen
 * @title:SettingController
 * @description:the controller of setting
 * @version: v1.0
 */

public class SettingController implements Initializable {
    @FXML
    private ChoiceBox<String> scene;

    @FXML
    private ChoiceBox<String> hero;

    @FXML
    private ImageView okBtn;

    @FXML
    private ChoiceBox<String> level;

    /**
     * make sure the settings
     * @param event
     */
    @FXML
    void clickOkBtn(MouseEvent event) {
        Setting.setLevel(level.getSelectionModel().getSelectedItem());
        Setting.setHeroType(hero.getSelectionModel().getSelectedItem());
        Setting.setSCENE(scene.getSelectionModel().getSelectedItem());
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);

        //back to index page
        Director.getInstance().goIndexPage();
    }

    @FXML
    void enterOkbtn(MouseEvent event) {
        okBtn.setOpacity(0.8);
    }

    @FXML
    void exitOkBtn(MouseEvent event) {
        okBtn.setOpacity(1);
    }

    /**
     * init the setting page
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //scene
        scene.getSelectionModel().select(Setting.getSCENE());
        scene.getItems().add("Old Story");
        scene.getItems().add("Hack");
        scene.getItems().add("Sweet");
        scene.getItems().add("Blue Sky");
        scene.getSelectionModel().select(Setting.getSCENE());
        //
        hero.getSelectionModel().select(Setting.HERO_TYPE);
        hero.getItems().add("Red");
        hero.getItems().add("Blue");
        hero.getItems().add("Green");
        hero.getItems().add("Orange");
        hero.getSelectionModel().select(Setting.getHeroType());
        //
        level.getSelectionModel().select(Setting.getLevel());
        level.getItems().add("easy");
        level.getItems().add("middle");
        level.getItems().add("hard");
        level.getSelectionModel().select(Setting.getLevel());
    }
}
