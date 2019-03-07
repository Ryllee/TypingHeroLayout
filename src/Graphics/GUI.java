package Graphics;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GUI extends BorderPane {

    public GUI(WordPanel wordpanel,UpgradePanel upgradepanel, PointCounterPanel pointcounterpanel,HealthPanel healthpanel){

        setLayoutWordPanel(wordpanel);
        setLayoutUpgradePanel(upgradepanel);
        setLayoutPointCounterPanel(pointcounterpanel);

        BorderPane gameplayWindow = new BorderPane();
        gameplayWindow.setBackground(new Background(new BackgroundFill(Color.web("#2d2d2d"), CornerRadii.EMPTY, Insets.EMPTY)));
        gameplayWindow.setCenter(wordpanel);
        gameplayWindow.setBottom(healthpanel);
        gameplayWindow.setMargin(healthpanel,new Insets(20,20,20,20));


        setTop(pointcounterpanel);
        setBottom(upgradepanel);
        setCenter(gameplayWindow);
    }
    private void setLayoutWordPanel(WordPanel wordpanel){
       // wordpanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    private void setLayoutUpgradePanel(UpgradePanel upgradepanel){
        upgradepanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    private void setLayoutPointCounterPanel(PointCounterPanel pointcounterpanel){
        //pointcounterpanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pointcounterpanel.setPrefHeight(50);
    }

}
