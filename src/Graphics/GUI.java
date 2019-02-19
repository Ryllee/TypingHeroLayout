package Graphics;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GUI extends BorderPane {

    public GUI(WordPanel wordpanel,UpgradePanel upgradepanel, PointCounterPanel pointcounterpanel){

        setLayoutWordPanel(wordpanel);
        setLayoutUpgradePanel(upgradepanel);
        setLayoutPointCounterPanel(pointcounterpanel);

        setTop(pointcounterpanel);
        setLeft(upgradepanel);
        setCenter(wordpanel);
    }
    private void setLayoutWordPanel(WordPanel wordpanel){
        wordpanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    private void setLayoutUpgradePanel(UpgradePanel upgradepanel){
        upgradepanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    private void setLayoutPointCounterPanel(PointCounterPanel pointcounterpanel){
        pointcounterpanel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pointcounterpanel.getChildren().add(new Text("TEST"));
        pointcounterpanel.setPrefHeight(100);
    }

}
