package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;



public class GameOverScene {


    private StackPane mainWindow;

    /**
     * Konstruktor för GameOverScene, skapar allt som behöves i scenen
     */
    public GameOverScene() {
        mainWindow = new StackPane();
            Button back = new Button("Back to menu");
            back.setOnAction(event -> Main.launchStartScene());
            back.setTranslateY(100);
            Label hslabel = new Label("GAME OVER");
            mainWindow.getChildren().add(hslabel);
            mainWindow.getChildren().add(back);
        }


    /**
     * Skapar en Scene av GameOver
     * @return Scenen av GameOver
     */
    public Scene getScene(){
        return new Scene(mainWindow,390,390);
    }
}


