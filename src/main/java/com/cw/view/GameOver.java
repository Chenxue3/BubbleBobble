package com.cw.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author:xueshanChen
 * @title:GameOver
 * @description:GameOver
 * @version: v1.0
 */

public class GameOver {
    public static void GameOver(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/layouts/gameOver.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
