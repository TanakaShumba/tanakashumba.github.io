package game.minesweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Minesweeper Game");

        // Create a GridPane for the Minesweeper grid
        GridPane grid = new GridPane();

        // Initialize the game state (we will set this up later)
        GameState gameState = new GameState();
        gameState.initializeBoard(grid);

        // Create the scene with the grid and display it
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
