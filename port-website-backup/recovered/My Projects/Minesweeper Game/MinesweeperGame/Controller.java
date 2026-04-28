package game.minesweeper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private GridPane gridPane;

    private Button[][] buttons = new Button[10][10];

    public void initialize() {
        System.out.println("Game started!");

        // Initialize buttons from FXML
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                String buttonId = "button(" + row + "," + col + ")";
                buttons[row][col] = (Button) gridPane.lookup("#" + buttonId);

                if (buttons[row][col] != null) {
                    buttons[row][col].setOnAction(event -> handleButtonClick((Button) event.getSource()));
                }
            }
        }
    }

    @FXML
    private void handleButtonClick(Button clickedButton) {
        System.out.println("Button " + clickedButton.getId() + " clicked!");
    }
}
