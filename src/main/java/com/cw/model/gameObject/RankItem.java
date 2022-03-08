package com.cw.model.gameObject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author:xueshanChen
 * @title:RankItem
 * @description:the rank of the game
 * @version: v1.0
 */

public class RankItem {
    private SimpleIntegerProperty score;

    private SimpleStringProperty date;

    private SimpleStringProperty name;

    private SimpleIntegerProperty rank;

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public SimpleIntegerProperty getRank(){
        return rank;
    }
    public void setRank(int rank) {
        this.rank.set(rank);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    /**
     * constructor of the rank
     */
    public RankItem(){
        this.date = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.score = new SimpleIntegerProperty();
        this.rank = new SimpleIntegerProperty();
    }

}
