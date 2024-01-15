package GameLoop_Dinova;

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
        int i = 0;
        Scanner input = new Scanner(System.in);
        while (i<9) {
            this.gameManager.notifyObservers();
            this.gameBoard.display();
            
            int playerInput = input.nextInt();
            this.gameManager.getCurrentPlayer().setComand(new MoveCommand(this.gameBoard, playerInput, gameManager.getCurrentPlayer().getPlayerSymbol()));
            this.gameManager.getCurrentPlayer().makeMove();
            this.gameManager.switchPlayer();

            i++;
        }
        input.close();
    }
}
