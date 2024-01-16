package GameLoop_Dinova;

import java.util.InputMismatchException;
import java.util.Scanner;

import Command_Potocnak.MoveCommand;
import Composite_Dinova.GameBoard;
import Observer_Dinova.GameEndObserver;
import Observer_Dinova.GameObserver;
import Observer_Dinova.PlayerTurnObserver;
import Singleton_Dinova.GameManager;

public class GameLoop {
    private GameManager gameManager;
    private GameBoard gameBoard;

    private GameObserver turnObserver;
    private GameObserver gameEndObserver;

    private void setUpGame() {
        this.gameManager = GameManager.getGameInstance();
        this.gameBoard = gameManager.getGameBoard();

        this.turnObserver = new PlayerTurnObserver(this.gameManager.getCurrentPlayer());
        this.gameEndObserver = new GameEndObserver();

        gameManager.addObserver(turnObserver);
        gameManager.addObserver(gameEndObserver);
    }

    public void runGame() {
        setUpGame();
        Scanner input = new Scanner(System.in);
        boolean endGame = false;
        while (!endGame) {
            this.gameManager.notifyObservers();
            this.gameBoard.display();
            int playerInput;

            try {
                playerInput = input.nextInt();
                this.gameManager.getCurrentPlayer().setComand(new MoveCommand(this.gameBoard, playerInput, gameManager.getCurrentPlayer().getPlayerSymbol()));

            if (gameManager.canMakeMove(playerInput)) {
                this.gameManager.getCurrentPlayer().makeMove(playerInput);
                this.gameManager.switchPlayer();
            }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! You can only input numbers!");
                input.next();
            }
            endGame = gameManager.hasGameEnded();
        }

        this.gameManager.notifyObservers();
        this.gameBoard.display();

        input.close();
    }
}
