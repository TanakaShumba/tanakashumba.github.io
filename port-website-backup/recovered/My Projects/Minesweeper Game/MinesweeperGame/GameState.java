package game.minesweeper;

import javafx.scene.layout.GridPane;

public class GameState {
    private MineSquare[][] board;
    private int rows = 10;
    private int cols = 10;

    public GameState() {
        board = new MineSquare[rows][cols];
    }

    public void initializeBoard(GridPane grid) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                MineSquare square = new MineSquare();
                board[row][col] = square;
                grid.add(square, col, row);  // Adds each square to the grid
            }
        }
        // Add logic for generating mines and numbers later
    }
}
