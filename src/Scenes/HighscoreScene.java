package Scenes;

import THutil.Network.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.LinkedHashMap;
import java.util.Set;

public class HighscoreScene {

    private StackPane mainWindow;

    public HighscoreScene() {
        mainWindow = new StackPane();
        LinkedHashMap<String, String> highscore = Client.getHighscore();
        if (highscore != null) {
            Set<String> keys = highscore.keySet();
            int rowindex = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("HIGHSCORE \n \n");
            for (String hs : keys) {
                String username = hs.substring(0, hs.length() - 4);
                sb.append((rowindex + 1) + ": " + username + " " + highscore.get(hs) + "\n");
                rowindex++;
            }
            Button back = new Button("Back to menu");
            back.setOnAction(event -> Main.launchStartScene());
            back.setTranslateY(100);
            Label hslabel = new Label(sb.toString());
            mainWindow.getChildren().add(hslabel);
            mainWindow.getChildren().add(back);
        }
    }


    public Scene getScene(){
        return new Scene(mainWindow,390,390);
    }
}
