package game.minesweeper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Scanner;

public class

GameScene {
    double borderWidth = 8.0;
    public Scene gameScene;
    public Button checkVictory;
    ImageView [] displayTimeArray;
    ImageView [] displayFlagsArray;
    Timeline timeline;
    int timerCount;
    int flagCount;
    GameState gameState;
    MineSquare [][]mineSquare;
    NumberSprites numberSprites;
    int boardSizeHeight;
    int boardSizeWidth;
    boolean gameOver;
    boolean gameCurrentlyRunning;
    GameResult gameResult;

    GameScene(double windowWidth, double windowHeight, int boardSizeHeight, int boardSizeWidth, int mineCount, GameResult gameResult) {
        numberSprites = new NumberSprites();
        this.boardSizeHeight = boardSizeHeight;
        this.boardSizeWidth = boardSizeWidth;
        this.gameResult = gameResult;
        this.gameCurrentlyRunning = true;

        Rectangle outLine = new Rectangle(borderWidth / 2, borderWidth / 2, windowWidth - ((borderWidth / 2) * 2), windowHeight - ((borderWidth / 2) * 2));
        //For the upper left start point the borderWidth/2 gives the
        //stroke enough room to show the whole stroke.
        //For the bottom right corner the borderWidth/2 must be multiplied by two
        //and then subtracted in order to compensate for the upper right corner also being moved
        outLine.setStroke(Color.GRAY);
        outLine.setStrokeWidth(borderWidth);
        outLine.setFill(Color.TRANSPARENT);


        Rectangle centerBorder = new Rectangle(0, 62, windowWidth, borderWidth);
        centerBorder.setFill(Color.GRAY);

        Rectangle informationRectangle = new Rectangle(0, 0, 600, 62);
        informationRectangle.setFill(Color.rgb(132, 144, 153));

        checkVictory = new Button("Submit");
        checkVictory.setLayoutX(windowWidth/2 - 45);
        checkVictory.setLayoutY(25);

        displayTimeArray = new ImageView[3];
        for(int i = 0; i < 3; i++)
        {
            displayTimeArray[i] = new ImageView(numberSprites.noNumberSprite);
            displayTimeArray[i].setLayoutY(24);
        }
        displayTimeArray[0].setLayoutX(windowWidth - (windowWidth * 0.03 + 15));
        displayTimeArray[1].setLayoutX(windowWidth - (windowWidth * 0.03 + 30));
        displayTimeArray[2].setLayoutX(windowWidth - (windowWidth * 0.03 + 45));

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event event) {
                                int[] numPlaces = new int [3];
                                timerCount++;
                                numPlaces[0] = timerCount % 10;
                                numPlaces[1] = (((timerCount - numPlaces[0])) % 100) / 10;
                                numPlaces[2] = (timerCount - numPlaces[0] - (((timerCount - numPlaces[0])) % 100)) / 100;
                                for(int iterator = 0; iterator < 3; iterator++)
                                {
                                    switch (numPlaces[iterator]) {
                                        case 0:
                                            displayTimeArray[iterator].setImage(numberSprites.zeroSprite);
                                            break;
                                        case 1:
                                            displayTimeArray[iterator].setImage(numberSprites.oneSprite);
                                            break;
                                        case 2:
                                            displayTimeArray[iterator].setImage(numberSprites.twoSprite);
                                            break;
                                        case 3:
                                            displayTimeArray[iterator].setImage(numberSprites.threeSprite);
                                            break;
                                        case 4:
                                            displayTimeArray[iterator].setImage(numberSprites.fourSprite);
                                            break;
                                        case 5:
                                            displayTimeArray[iterator].setImage(numberSprites.fiveSprite);
                                            break;
                                        case 6:
                                            displayTimeArray[iterator].setImage(numberSprites.sixSprite);
                                            break;
                                        case 7:
                                            displayTimeArray[iterator].setImage(numberSprites.sevenSprite);
                                            break;
                                        case 8:
                                            displayTimeArray[iterator].setImage(numberSprites.eightSprite);
                                            break;
                                        case 9:
                                            displayTimeArray[iterator].setImage(numberSprites.nineSprite);
                                    }
                                }
                            }
                        }));

        displayFlagsArray = new ImageView[2];
        for(int i = 0; i < 2; i++)
        {
            displayFlagsArray[i] = new ImageView(numberSprites.noNumberSprite);
            displayFlagsArray[i].setLayoutY(24);
        }
        displayFlagsArray[0].setLayoutX(windowWidth * 0.03 + 15);
        displayFlagsArray[1].setLayoutX(windowWidth * 0.03);

        gameState = new GameState(boardSizeHeight, boardSizeWidth);
        gameState.seedMines(mineCount);
        flagCount = mineCount;

        mineSquare = new MineSquare[boardSizeHeight][boardSizeWidth];
        for(int rows = 0; rows < boardSizeHeight; rows++) {
            for(int columns = 0; columns < boardSizeWidth; columns++)
            {
                mineSquare[rows][columns] = new MineSquare();
                mineSquare[rows][columns].changeToCoveredSquare();
                mineSquare[rows][columns].setId("" + rows + " " + columns);
                mineSquare[rows][columns].setOnMouseClicked(this::squareClicked);
                mineSquare[rows][columns].setFitWidth((windowWidth - (borderWidth * 2 + 1))/boardSizeWidth);
                mineSquare[rows][columns].setFitHeight((windowHeight - 78)/boardSizeHeight);
            }
        }

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(8);
        gridPane.setLayoutY(70);
        for(int rows = 0; rows < boardSizeHeight; rows++) {
            for (int columns = 0; columns < boardSizeWidth; columns++) {
                gridPane.add(mineSquare[rows][columns],columns, rows); //organized as columns and then rows
            }
        }

        Group gameBackGround = new Group(informationRectangle, centerBorder, outLine, displayTimeArray[0],
                displayTimeArray[1], displayTimeArray[2], displayFlagsArray[0], displayFlagsArray[1], checkVictory, gridPane);
        gameScene = new Scene(gameBackGround, 600, 500, Color.WHITESMOKE);
    }

    public Scene getGameScene() {
        timeline.playFromStart();
        updateFlagCountDisplay();
        return gameScene;
    }
    
    private void updateFlagCountDisplay()
    {
        int [] minesLeftArray = new int [2];
        minesLeftArray[0] = (flagCount == 1) ? 1 : flagCount % 10;
        minesLeftArray[1] = (flagCount == 1) ? 0 : (flagCount - minesLeftArray[0]) / 10;

        for(int iterator = 0; iterator < 2; iterator++)
        {
            switch (minesLeftArray[iterator]) {
                case 0:
                    displayFlagsArray[iterator].setImage(numberSprites.zeroSprite);
                    break;
                case 1:
                    displayFlagsArray[iterator].setImage(numberSprites.oneSprite);
                    break;
                case 2:
                    displayFlagsArray[iterator].setImage(numberSprites.twoSprite);
                    break;
                case 3:
                    displayFlagsArray[iterator].setImage(numberSprites.threeSprite);
                    break;
                case 4:
                    displayFlagsArray[iterator].setImage(numberSprites.fourSprite);
                    break;
                case 5:
                    displayFlagsArray[iterator].setImage(numberSprites.fiveSprite);
                    break;
                case 6:
                    displayFlagsArray[iterator].setImage(numberSprites.sixSprite);
                    break;
                case 7:
                    displayFlagsArray[iterator].setImage(numberSprites.sevenSprite);
                    break;
                case 8:
                    displayFlagsArray[iterator].setImage(numberSprites.eightSprite);
                    break;
                case 9:
                    displayFlagsArray[iterator].setImage(numberSprites.nineSprite);
            }
        }
    }
    private void clearAdjacentSquares(int row, int column)
    {
        if(row < 0 || column < 0 || row > boardSizeHeight - 1 || column > boardSizeWidth - 1)
        {
            return;
        }
        if(mineSquare[row][column].getImage() == MineSquare.uncoveredBlankSquare)
        {
            return;
        }
        int adjMines = gameState.countAdjMines(column, row);
        if(adjMines > 0)
        {
            mineSquare[row][column].changeToNumberSquare(adjMines);
            return;
        }
        mineSquare[row][column].changeToUncoveredBlankSquare();
        clearAdjacentSquares(row - 1, column);
        clearAdjacentSquares(row + 1, column);
        clearAdjacentSquares(row, column - 1);
        clearAdjacentSquares(row, column + 1);
    }

    private void squareClicked(MouseEvent event) {
        if (!gameOver) {
            String id = ((MineSquare) event.getSource()).getId();
            Scanner sc = new Scanner(id);
            int row = sc.nextInt();
            int column = sc.nextInt();
            //System.out.println("Row: " + row);
            //System.out.println("Column: " + column);
            //System.out.println("Before: " + gameState.getaGridCord(column, row));
            System.out.println((mineSquare[row][column]).getImage().getPixelReader().getColor(0,0));
            System.out.println(MineSquare.flagSquare.getPixelReader().getColor(0,0));

            if (event.getButton() == MouseButton.PRIMARY) {
                if(!(mineSquare[row][column].getImage().getPixelReader().getColor(0,0).equals(MineSquare.flagSquare.getPixelReader().getColor(0,0))))
                {
                    if (gameState.isMine(column, row)) // clicked on a mine
                    {
                        mineSquare[row][column].changeToRedMineSquare();
                        checkVictory.setText("You lost, end game?");
                        gameOver = true;
                        timeline.stop();
                        gameResult.timeToCompleteGame = timerCount;
                        gameResult.didWin = false;
                    }
                    else { //did not click on a mine
                        int numAdjMines = gameState.countAdjMines(column, row);
                        if (numAdjMines > 0) //if the space has adjacent mines, do not clear anything
                        {
                            mineSquare[row][column].changeToNumberSquare(numAdjMines);
                        }
                        else //if the space does not have adjacent mines, clear spaces until clearing the area
                        {
                            clearAdjacentSquares(row, column);
                            //System.out.println("BlankSquare");
                        }
                    }
                }

            }
            if (event.getButton() == MouseButton.SECONDARY) {
                if ((mineSquare[row][column].getImage().getPixelReader().getColor(0,0).equals(MineSquare.flagSquare.getPixelReader().getColor(0,0)))) {
                    mineSquare[row][column].changeToCoveredSquare();
                    gameState.flagSquare(column, row);
                    flagCount++;
                }
                else {
                    if ((flagCount >= 0) && (mineSquare[row][column]).checkCoveredSquare()) {
                        mineSquare[row][column].changeToFlagSquare();
                        gameState.flagSquare(column, row);
                        flagCount--;
                    }
                }
                System.out.println((mineSquare[row][column]).getImage().getUrl());
                System.out.println(MineSquare.coveredSquare);
            }
            updateFlagCountDisplay();

        }
    }

    public void checkVictory()
    {
        if(gameState.isVictory())
        {
            gameResult.didWin = true;
            timeline.stop();
            gameResult.timeToCompleteGame = timerCount;
        }
        else
        {
            gameResult.didWin = false;
            timeline.stop();
            gameResult.timeToCompleteGame = timerCount;
        }
    }
}

