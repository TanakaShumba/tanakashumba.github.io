package game.minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class GameDriver extends Application {
    TitleScene titleScene;
    GameScene gameScene;
    WinLoseScene winLoseScene;
    Stage stage;
    GameResult gameResult;
    int windowWidth = 600;
    int windowHeight = 500;
    public void start(Stage primaryStage){
        titleScene   = new TitleScene(windowWidth, windowHeight);
        winLoseScene = new WinLoseScene(windowWidth, windowHeight);
        stage        = new Stage();

        titleScene.startGameButton.setOnMouseClicked(this::startGameButtonPushed);
        winLoseScene.backToTitleButton.setOnMouseClicked(this::backToTitleButtonPushed);
        stage.setScene(titleScene.getScene());
        stage.setTitle("MineSweeper");

        primaryStage = stage;
        primaryStage.show();

    }

    void startGameButtonPushed(MouseEvent event)
    {
        gameResult = new GameResult();
        gameScene = new GameScene(windowWidth, windowHeight, 20, 20, 10, gameResult);
        gameScene.checkVictory.setOnMouseClicked(this::checkVictoryButtonPush);
        stage.setScene(gameScene.getGameScene());
    }

    void backToTitleButtonPushed(MouseEvent event)
    {
        stage.setScene(titleScene.getScene());
    }

    void checkVictoryButtonPush(MouseEvent event)
    {
        gameScene.checkVictory();
        stage.setScene(winLoseScene.getEndScreenScene(gameResult));
    }

    public static void main(String[] args) {
        launch();
    }
}