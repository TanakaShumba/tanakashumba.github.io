package game.minesweeper;

import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class TitleScene{
    public Button startGameButton;
    public Group introGroup;
    public Scene intro;
    TitleScene(double xWindowWidth, double yWindowWidth)
    {
        Text gameTitle = new Text("MineSweeper");
        gameTitle.setFont(Font.font("Cooper Black", 80));
        gameTitle.setStrokeWidth(3);
        gameTitle.setStroke(Color.BLACK);
        gameTitle.setFill(Color.NAVAJOWHITE);
        gameTitle.setX((xWindowWidth - gameTitle.getLayoutBounds().getWidth()) * 0.5);
        gameTitle.setY(100);

        Text credits = new Text("Creators: Tristan Delgado, Alex King, Tanaka Shumba");
        credits.setFont(Font.font("Bahnschrift", 15));
        credits.setFill(Color.WHITE);
        credits.setX((xWindowWidth - credits.getLayoutBounds().getWidth()) * 0.5);
        credits.setY(yWindowWidth - (yWindowWidth * .10));

        startGameButton = new Button("Start Game");
        startGameButton.setTextFill(Color.BLACK);
        startGameButton.setBackground(Background.fill(Color.TAN));
        startGameButton.setPrefHeight(15);
        startGameButton.setPrefWidth(100);
        startGameButton.setLayoutX((xWindowWidth/2) - 50);
        startGameButton.setLayoutY(yWindowWidth - (yWindowWidth * (2.0/3.0)));

        introGroup = new Group(gameTitle, credits, startGameButton);
        intro      = new Scene(introGroup, xWindowWidth, yWindowWidth, Color.GRAY);
    }

    public Scene getScene(){return intro;}

}
