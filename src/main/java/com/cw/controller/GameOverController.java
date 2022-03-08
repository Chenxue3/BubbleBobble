package com.cw.controller;

import com.cw.utility.Sound;
import com.cw.utility.world.Director;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author:xueshanChen
 * @title:GameOverController
 * @description:controller of game over page
 * @version: v1.0
 */

public class GameOverController implements Initializable{
    @FXML
    private ImageView backBtn;
    @FXML
    private Text score;

    @FXML
    void clickBack(MouseEvent event) {
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);
        Director.getInstance().clearScore();
        Director.getInstance().goIndexPage();
    }

    @FXML
    void enterBtn(MouseEvent event) {
        backBtn.setOpacity(0.8);
    }

    @FXML
    void exitBtn(MouseEvent event) {
        backBtn.setOpacity(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        score.setText("YOUR SCORE: "+ Director.getInstance().getScore());
    }
}
