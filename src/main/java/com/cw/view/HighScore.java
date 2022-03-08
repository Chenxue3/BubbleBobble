package com.cw.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author:xueshanChen
 * @title:HighScore
 * @description:high score
 * @version: v1.0
 */

public class HighScore {
    /**
     * load the FXML file of the start page and display
     *
     * @param stage
     */
    public static void HighScore(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/layouts/highScore.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
