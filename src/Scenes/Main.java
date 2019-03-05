package Scenes;


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

    /**
     * launchSinglePlayer
     * Skapar SinglePlayer och sätter primaryStage Scene till singleplayer
     * @param username tar in username som används i olika funktionen tex spara/ladda
     */
    public static void launchSinglePlayer(String username){
        SinglePlayer singleplayer = new SinglePlayer(username);
        primaryStage.setScene(singleplayer.getScene());
    }

    /**
     * launchHighscore
     * Skapar HighscoreScene och sätter primaryStage Scene till highscore
     */
    public static void launchHighscore(){
        HighscoreScene highscore = new HighscoreScene();
        primaryStage.setScene(highscore.getScene());
    }
    /**
     * launchStartScene
     * Skapar StartScene och sätter primaryStage Scene till startScene
     */
    public static void launchStartScene(){
        StartScene startScene = new StartScene();
        primaryStage.setScene(startScene.getScene());
    }
    /**
     * launchGameOverScene
     * Skapar gameOverScene och sätter primaryStage Scene till gameover
     */
    public static void launchGameOverScene(){
        GameOverScene gameover = new GameOverScene();
        primaryStage.setScene(gameover.getScene());
    }
}
