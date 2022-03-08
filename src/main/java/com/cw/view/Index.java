package com.cw.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author:xueshanChen
 * @title:Index
 * @description:This is the index of this game
 * @version: v1.0
 */

public class Index {
    /**
     * load the FXML file of the start page and display
     *
     * @param stage
     */
    public static void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/layouts/index.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
