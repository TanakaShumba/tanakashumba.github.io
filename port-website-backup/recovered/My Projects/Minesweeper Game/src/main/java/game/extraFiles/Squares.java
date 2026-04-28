package game.extraFiles;

public class Squares {
    /*

package game.extraFiles;

import java.util.Random;
import java.util.Scanner;

public class MinesSweeper {
    private static final int ROWS = 8;
    private static final int COLUMNS = 15;
    private static final int NUM_MINES = 20;

    private char[][] gameBoard;
    private char[][] mineBoard;
    private boolean[][] revealed;
    private int minesLeft;

    public MinesweeperGame() {
        gameBoard = new char[ROWS][COLUMNS];
        mineBoard = new char[ROWS][COLUMNS];
        revealed = new boolean[ROWS][COLUMNS];
        minesLeft = NUM_MINES;
        initializeGame();
    }

    public void initializeGame() {
        // Initialize game board with empty cells
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                gameBoard[row][col] = ' ';
                mineBoard[row][col] = ' ';
                revealed[row][col] = false;
            }
        }

        // Randomly place mines
        placeMines();

        // Fill in numbers around mines
        fillNumbers();
    }

    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < NUM_MINES) {
            int row = random.nextInt(ROWS);
            int col = random.nextInt(COLUMNS);

            if (mineBoard[row][col] != 'X') {
                mineBoard[row][col] = 'X';
                minesPlaced++;
            }
        }
    }

    public void fillNumbers() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (mineBoard[row][col] == 'X') {
                    incrementNeighbors(row, col);
                }
            }
        }
    }

    public void incrementNeighbors(int row, int col) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int r = row + dr;
                int c = col + dc;

                if (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && mineBoard[r][c] != 'X') {
                    mineBoard[r][c]++;
                }
            }
        }
    }

    public void displayGameBoard() {
        System.out.println("Minesweeper Game");
        System.out.print("   ");
        for (int col = 0; col < COLUMNS; col++) {
            System.out.printf("%2d ", col);
        }
        System.out.println();

        for (int row = 0; row < ROWS; row++) {
            System.out.printf("%2d ", row);
            for (int col = 0; col < COLUMNS; col++) {
                char cell = revealed[row][col] ? gameBoard[row][col] : ' ';
                System.out.printf("[%c]", cell);
            }
            System.out.println();
        }
    }

    public boolean isGameOver() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (!revealed[row][col] && gameBoard[row][col] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            displayGameBoard();
            System.out.print("Enter row and column (e.g., 2 3): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && !revealed[row][col]) {
                if (mineBoard[row][col] == 'X') {
                    gameOver = true;
                } else if (mineBoard[row][col] == '0') {
                    revealEmptyCells(row, col);
                } else {
                    gameBoard[row][col] = mineBoard[row][col];
                    revealed[row][col] = true;
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }

            if (!gameOver) {
                gameOver = isGameOver();
            }
        }

        if (gameOver) {
            displayGameBoard();
            System.out.println("Game Over! You hit a mine.");
        } else {
            System.out.println("Congratulations! You've won!");
        }
    }

    public void revealEmptyCells(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS || revealed[row][col] || mineBoard[row][col] == 'X') {
            return;
        }

        gameBoard[row][col] = mineBoard[row][col];
        revealed[row][col] = true;

        if (mineBoard[row][col] == '0') {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    revealEmptyCells(row + dr, col + dc);
                }
            }
        }
    }

    public static void main(String[] args) {
        MinesweeperGame game = new MinesweeperGame();
        game.playGame();
    }
}
 */

}
