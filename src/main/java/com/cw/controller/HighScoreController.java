package com.cw.controller;

import com.cw.utility.world.Director;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @author:xueshanChen
 * @title:HighScoreController
 * @description:controller of high score
 * @version: v1.0
 */

public class HighScoreController {
    @FXML
    private ImageView okBtn;

    @FXML
    void clickOk(MouseEvent event) {
        Director.getInstance().goIndexPage();
    }

    @FXML
    void enterOk(MouseEvent event) {
        okBtn.setOpacity(0.8);
    }

    @FXML
    void exitOk(MouseEvent event) {
        okBtn.setOpacity(1);
    }
}
