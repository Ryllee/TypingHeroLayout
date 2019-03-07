package Scenes;

import THutil.Network.Client;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
            Label hslabel = new Label(sb.toString());
            hslabel.setFont(Font.font("Helvetica", 15));
            mainWindow.getChildren().add(hslabel);
        } else {
            Label connectionErrorLabel = new Label("Couldn't connect to server.");
            mainWindow.getChildren().add(connectionErrorLabel);
        }
        Button back = new Button("Back to menu");
        back.setOnAction(event -> Main.launchStartScene());
        back.setTranslateY(100);

        mainWindow.getChildren().add(back);
    }


    public Scene getScene(){
        return new Scene(mainWindow,390,390);
    }
}
