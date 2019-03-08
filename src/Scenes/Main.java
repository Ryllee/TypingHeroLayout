package Scenes;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    private static Stage primaryStage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.primaryStage = primaryStage;
        String url = System.getProperty("user.dir");
        primaryStage.getIcons().add(new Image("file:"+url+"/res/iconTH.png"));
        primaryStage.setTitle("Typing Hero");
        launchStartScene();

        // SHOW SCENE
        primaryStage.show();

    }

    /**
     * Skapar SinglePlayer och sätter primaryStage Scene till singleplayer
     * @param username tar in username som används i olika metoder tex spara/ladda
     */
    public static void launchSinglePlayer(String username){
        SinglePlayer singleplayer = new SinglePlayer(username);
        primaryStage.hide();
        primaryStage.setScene(singleplayer.getScene());
        primaryStage.show();
    }

    /**
     * Skapar HighscoreScene och sätter primaryStage Scene till highscore
     */
    public static void launchHighscore(){
        HighscoreScene highscore = new HighscoreScene();
        primaryStage.setScene(highscore.getScene());
    }
    /**
     * Skapar StartScene och sätter primaryStage Scene till startScene
     */
    public static void launchStartScene(){
        StartScene startScene = new StartScene();
        primaryStage.setScene(startScene.getScene());
    }
    /**
     * Skapar gameOverScene och sätter primaryStage Scene till gameover
     */
    public static void launchGameOverScene(){
        GameOverScene gameover = new GameOverScene();
        primaryStage.hide();
        primaryStage.setScene(gameover.getScene());
        primaryStage.show();
    }
}
