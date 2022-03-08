package com.cw.view;

import com.cw.model.gameObject.RankItem;
import com.cw.utility.world.Director;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:xueshanChen
 * @title:Rank
 * @description:the rank
 * @version: v1.0
 */

public class Rank {
    private Stage stage;
    private static Director instance = new Director();
    private static String rankFile = "src\\main\\resources\\world\\rank.csv";
    public static int highScore = 0;

    /**
     * load the FXML file of the start page and display
     *
     * @param stage
     */
    public static void rankPage(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/layouts/rank.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * time format
     */
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * write name, score and time into the file
     * @param name
     */
    public void writeScore(String name) {
        LocalDateTime time = LocalDateTime.now();
        String format = formatter.format(time);
        // write score to file
        File file = new File(rankFile);
        if (! file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            highScore = Director.getInstance().getScore();
            writer.write(name + "," + Director.getInstance().getScore() + "," + format);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * read the rank.csv
     * @return rank table
     */
    public static List<RankItem> readFile(){

        File file = new File(rankFile);
        List<RankItem> rankTable = new ArrayList<RankItem>();
        if (! file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && line.length() > 0) {
                String[] re = line.split(",");
                RankItem rankItem = new RankItem();
                rankItem.setName(re[0]);
                rankItem.setScore(Integer.parseInt(re[1]));
                rankItem.setDate(re[2]);
                rankTable.add(rankItem);
                line = reader.readLine();
            }
            rankTable.stream().sorted((x1, x2) -> x2.getScore() - x1.getScore()).collect(Collectors.toList());
            for (int i = 0; i < rankTable.size(); i++) {
                rankTable.get(i).setRank(i + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rankTable;
    }

    public static boolean isHighest(int score){
        return score>=70;
    }
}
