
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
        Timer timer = new Timer(true);
        SinglePlayer singleplayer = new SinglePlayer(username,timer);
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
    
}
