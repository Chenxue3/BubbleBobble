package com.cw.controller;

import com.cw.model.gameObject.RankItem;
import com.cw.utility.Sound;
import com.cw.utility.world.Director;
import com.cw.view.Rank;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author:xueshanChen
 * @title:RankController
 * @description:the controller of rank page
 * @version: v1.0
 */

public class RankController implements Initializable {
    @FXML
    private TableView table;

    @FXML
    private ImageView btn;

    @FXML
    void clickBtn(MouseEvent event) {
        Sound.playSound(Sound.BUTTON_ON_CLICK_SONG);
        Director.getInstance().goIndexPage();
    }

    @FXML
    void enterBtn(MouseEvent event) {
        btn.setOpacity(0.8);
    }

    @FXML
    void exitBtn(MouseEvent event) {
        btn.setOpacity(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<RankItem> rankItem = Rank.readFile();

        TableColumn rank = new TableColumn("rank");
        rank.setMinWidth(60);
        rank.setCellValueFactory(new PropertyValueFactory<RankItem,String>("rank"));

        TableColumn name = new TableColumn("name");
        name.setMinWidth(120);
        name.setCellValueFactory(new PropertyValueFactory<RankItem,String>("name"));


        TableColumn score = new TableColumn("score");
        score.setMinWidth(180);
        score.setCellValueFactory(new PropertyValueFactory<RankItem,Integer>("score"));


        TableColumn date = new TableColumn("date");
        date.setMinWidth(240);
        date.setCellValueFactory(new PropertyValueFactory<RankItem,String>("date"));

        ObservableList<RankItem> item = FXCollections.observableArrayList();
        item.addAll(rankItem);
        table.setItems(item);
        table.getColumns().addAll(name,score,date);
    }
}
