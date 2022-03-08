package com.cw.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author:xueshanChen
 * @title:Help
 * @description:the help page
 * @version: v1.0
 */

public class Help {

    public static void Help(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/layouts/Help.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
