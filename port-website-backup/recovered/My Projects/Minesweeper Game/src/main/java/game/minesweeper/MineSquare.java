package game.minesweeper;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class MineSquare extends ImageView {
    static public Image coveredSquare;
    static public Image uncoveredBlankSquare;
    static public Image flagSquare;
    static public Image mineSquare;
    static public Image redMineSquare;
    static public Image oneSquare;
    static public Image twoSquare;
    static public Image threeSquare;
    static public Image fourSquare;
    static public Image fiveSquare;
    static public Image sixSquare;
    static public Image sevenSquare;
    static public Image eightSquare;

    MineSquare() {
        coveredSquare        = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/CoveredSprite.png")));
        uncoveredBlankSquare = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/UncoveredBlankSquareSprite.png")));
        flagSquare           = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/FlagSquareSprite.png")));
        mineSquare           = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/MineSquareSprite.png")));
        redMineSquare        = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/RedMineSquareSprite.png")));
        oneSquare            = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/OneSquareSprite.png")));
        twoSquare            = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/TwoSquareSprite.png")));
        threeSquare          = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/ThreeSquareSprite.png")));
        fourSquare           = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/FourSquareSprite.png")));
        fiveSquare           = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/FiveSquareSprite.png")));
        sixSquare            = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/SixSquareSprite.png")));
        sevenSquare          = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/SevenSquareSprite.png")));
        eightSquare          = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/EightSquareSprite.png")));
    }

    public void changeToCoveredSquare() {
        this.setImage(coveredSquare);
    }

    public void changeToUncoveredBlankSquare() {
        this.setImage(uncoveredBlankSquare);
    }

    public void changeToFlagSquare() {
        this.setImage(flagSquare);
    }

    public void changeToMineSquare() {
        this.setImage(mineSquare);
    }

    public void changeToRedMineSquare() {
        this.setImage(redMineSquare);
    }

    public void changeToNumberSquare(int number) {
        switch (number) {
            case 1:
                this.setImage(oneSquare);
                break;
            case 2:
                this.setImage(twoSquare);
                break;
            case 3:
                this.setImage(threeSquare);
                break;
            case 4:
                this.setImage(fourSquare);
                break;
            case 5:
                this.setImage(fiveSquare);
                break;
            case 6:
                this.setImage(sixSquare);
                break;
            case 7:
                this.setImage(sevenSquare);
                break;
            case 8:
                this.setImage(eightSquare);
                break;
        }
    }

    public boolean checkCoveredSquare()
    {
        return (this.getImage().getPixelReader().getColor(0,0).equals(coveredSquare.getPixelReader().getColor(0,0)));
    }
}
