
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Timer;

public class Main extends Application {

    private Timer timer;
    private Stage primaryStage;

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

    public void launchSinglePlayer(String username){
        timer = new Timer();
        SinglePlayer singleplayer = new SinglePlayer(username,timer,this);
        primaryStage.setScene(singleplayer.getScene());
    }
    public void launchHighscore(){
        HighscoreScene highscore = new HighscoreScene(this);
        primaryStage.setScene(highscore.getScene());
    }
    public void launchStartScene(){
        StartScene startScene = new StartScene(this);
        primaryStage.setScene(startScene.getScene());
    }

    @Override
    public void stop() throws Exception {
        if(timer != null) {
            timer.cancel();
        }
        super.stop();
    }
}
