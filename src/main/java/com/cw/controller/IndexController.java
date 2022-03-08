package com.cw.controller;

/**
 * @author:xueshanChen
 * @title:IndexController
 * @description:This class contain the controllers of the index page, connect the model and the view.
 * @version: v1.0
 */

import com.cw.utility.ImageManagement;
import com.cw.utility.world.Director;
import com.cw.utility.Sound;
import com.cw.view.Setting;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class IndexController {

    @FXML
    private ImageView startGame;

    @FXML
    private ImageView rankingIconBtn;

    @FXML
    private ImageView instructionBtn;

    @FXML
    private ImageView mapIcon;

    @FXML
    private ImageView settingBtn;


    @FXML
    void mouseClickStartBtn(MouseEvent event) {
        System.out.println("click start"+Setting.getSCENE()+"==="+Setting.getHeroType());
        ImageManagement.enemyImgList();
        ImageManagement.styleImageManagement(Setting.getSCENE());
        ImageManagement.imageStore(Setting.getHeroType());
        Director.getInstance().gameStart();
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);
    }

    @FXML
    void clickInstructionBtn(MouseEvent event) {
        Director.getInstance().help();
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);

    }

    @FXML
    void clickOnMapIcon(MouseEvent event) {
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);

    }

    @FXML
    void clickRankingIcon(MouseEvent event) {
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);
        Director.getInstance().goRank();
    }

    @FXML
    void clickSettingBtn(MouseEvent event) throws IOException {
        Director.getInstance().gameSetting();
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);

    }

    @FXML
    void enterInstructionBtn(MouseEvent event) {
        instructionBtn.setOpacity(0.8);
    }

    @FXML
    void enterOnMapIcon(MouseEvent event) {
        mapIcon.setOpacity(0.8);
    }

    @FXML
    void enterRankingIcon(MouseEvent event) {
        rankingIconBtn.setOpacity(0.8);
    }

    @FXML
    void enterSettingBtn(MouseEvent event) {
        settingBtn.setOpacity(0.8);
    }

    @FXML
    void exitInstructionBtn(MouseEvent event) {
        instructionBtn.setOpacity(1);
    }

    @FXML
    void exitRankingIcon(MouseEvent event) {
        rankingIconBtn.setOpacity(1);
    }

    @FXML
    void exitSettingBtn(MouseEvent event) {
        settingBtn.setOpacity(1);
    }

    @FXML
    void exitedOnMapIcon(MouseEvent event) {
        mapIcon.setOpacity(1);
    }



    @FXML
    void mouseEnterStartBtn(MouseEvent event) {
        startGame.setOpacity(0.8);
    }

    @FXML
    void mouseExitStartBin(MouseEvent event) {
        startGame.setOpacity(1);
    }

}

