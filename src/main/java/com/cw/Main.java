package com.cw;

import com.cw.utility.world.Director;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author:xueshanChen
 * @title:Main
 * @description:the main class of the project
 * @version: v1.0
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Director.getInstance().init(stage);
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
