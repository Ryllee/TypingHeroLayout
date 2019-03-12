package Scenes;

import THutil.Network.Client;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


import java.util.LinkedHashMap;
import java.util.Set;
/**
 * Scen som visar highscore som laddas hem från server.
 * @author Eric Rylander
 * @version 2019-03-12
 */
public class HighscoreScene {

    private StackPane mainWindow;

    /**
     * Konstruktor för HighscoreScene skapar allt som behöves i Scenen
     */
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

    /**
     * Skapar en Scene av Highscore
     * @return Scenen av HighScore
     */
    public Scene getScene(){
        return new Scene(mainWindow,390,390);
    }
}
