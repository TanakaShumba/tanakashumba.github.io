/*

package game.extraFiles;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MinesweeperGame extends Application {
    private static final int GRID_SIZE = 10;
    private static final int SQUARE_SIZE = 30;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Minesweeper");

        Group root = new Group();
        Scene scene = new Scene(root, GRID_SIZE * SQUARE_SIZE, GRID_SIZE * SQUARE_SIZE);

        Rectangle[][] squares = new Rectangle[GRID_SIZE][GRID_SIZE];

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle square = new Rectangle(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                square.setFill(Color.LIGHTGRAY);
                square.setStroke(Color.BLACK);
                squares[row][col] = square;
                root.getChildren().add(square);
            }
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

 */
