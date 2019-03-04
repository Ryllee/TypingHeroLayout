package Scenes;

import Scenes.GameOverScene;
import Scenes.HighscoreScene;
import Scenes.SinglePlayer;
import Scenes.StartScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Timer;

public class Main extends Application {

    private Timer timer;
    private static Stage primaryStage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.primaryStage = primaryStage;
        launchStartScene();

        // SHOW SCENE
        primaryStage.show();

    }

    public static void launchSinglePlayer(String username){
        SinglePlayer singleplayer = new SinglePlayer(username);
        primaryStage.setScene(singleplayer.getScene());
    }
    public static void launchHighscore(){
        HighscoreScene highscore = new HighscoreScene();
        primaryStage.setScene(highscore.getScene());
    }
    public static void launchStartScene(){
        StartScene startScene = new StartScene();
        primaryStage.setScene(startScene.getScene());
    }
    public static void launchGameOverScene(){
        GameOverScene gameover = new GameOverScene();
        primaryStage.setScene(gameover.getScene());
    }
}
