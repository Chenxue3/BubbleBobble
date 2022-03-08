package com.cw.controller;

import com.cw.utility.Sound;
import com.cw.utility.world.Director;
import com.cw.view.Setting;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @author:xueshanChen
 * @title:HelpController
 * @description:controller of help
 * @version: v1.0
 */

public class HelpController {
    @FXML
    private ImageView okBtn;

    @FXML
    void clickOk(MouseEvent event) {
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);
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
