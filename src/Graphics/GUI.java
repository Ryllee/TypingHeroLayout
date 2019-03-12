package Graphics;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
/**
 * Tar emot alla paneler som behövs för att bygga upp användargränssnittet och placerar ut dessa.
 * @author Eric Rylander
 * @version 2019-03-12
 */
public class GUI extends BorderPane {
    /**
     * Skapar en layout för spelet
     * @param wordpanel vilken WordPanel som ska visas
     * @param upgradepanel vilken UpgradePanel som ska visas
     * @param pointcounterpanel vilken PointCounterPanel som ska visas
     * @param healthpanel vilken HealthPanel som ska visas
     */
    public GUI(WordPanel wordpanel,UpgradePanel upgradepanel, PointCounterPanel pointcounterpanel,HealthPanel healthpanel){

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

    /**
     * Sätter en border till en UpgradePanel
     * @param upgradepanel vilken UpgradePanel den ska sätta den till
     */
    private void setLayoutUpgradePanel(UpgradePanel upgradepanel){
        upgradepanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    /**
     * Sätter en prefHeight till en PointCounterPanel
     * @param pointcounterpanel vilken PointCounterPanel den ska sättas till
     */
    private void setLayoutPointCounterPanel(PointCounterPanel pointcounterpanel){
        pointcounterpanel.setPrefHeight(50);
    }

}
