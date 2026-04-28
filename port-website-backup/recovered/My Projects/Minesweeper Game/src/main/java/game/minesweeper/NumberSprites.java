package game.minesweeper;

import javafx.scene.image.Image;

import java.util.Objects;

public class NumberSprites {
    Image noNumberSprite;
    Image zeroSprite;
    Image oneSprite;
    Image twoSprite;
    Image threeSprite;
    Image fourSprite;
    Image fiveSprite;
    Image sixSprite;
    Image sevenSprite;
    Image eightSprite;
    Image nineSprite;
    NumberSprites()
    {
        noNumberSprite = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/NoNumberSprite.png")));
        zeroSprite     = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/ZeroSprite.png")));
        oneSprite      = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/OneSprite.png")));
        twoSprite      = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/TwoSprite.png")));
        threeSprite    = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/ThreeSprite.png")));
        fourSprite     = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/FourSprite.png")));
        fiveSprite     = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/FiveSprite.png")));
        sixSprite      = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/SixSprite.png")));
        sevenSprite    = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/SevenSprite.png")));
        eightSprite    = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/EightSprite.png")));
        nineSprite     = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/minesweeper/Images/NineSprite.png")));
    }
}
