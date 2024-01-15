package GameLoop_Dinova;

import java.util.Scanner;

import Command_Potocnak.Player;
import Composite_Dinova.GameBoard;
import Factory_Potocnak.PlayerOFactory;
import Factory_Potocnak.PlayerXFactory;
import Observer_Dinova.GameEndObserver;
import Observer_Dinova.GameObserver;
import Observer_Dinova.PlayerTurnObserver;
import Singleton_Dinova.GameManager;

public class GameLoop {
    private GameManager gameManager;
    private GameBoard gameBoard;

    private PlayerOFactory playerOFactory = new PlayerOFactory();
    private PlayerXFactory playerXFactory = new PlayerXFactory();

    private Player playerO;
    private Player playerX;

    private GameObserver turnObserver;
    private GameObserver gameEndObserver;

    private Player pickStartingPlayer() {
        this.playerO = playerOFactory.createPlayer();
        this.playerX = playerXFactory.createPlayer();
        long startingPlayerIndex = Math.round(Math.random());
        if (startingPlayerIndex == 0) {
            return playerO;
        }
        return playerX;
    }

    public void setUpGame() {
        this.gameManager = GameManager.getGameInstance();
        this.gameBoard = gameManager.getGameBoard();
        this.gameBoard.setCurrentPlayer(pickStartingPlayer());

        this.turnObserver = new PlayerTurnObserver(this.gameBoard.getCurrentPlayer());
        this.gameEndObserver = new GameEndObserver();

        gameManager.addObserver(turnObserver);
        gameManager.addObserver(gameEndObserver);
    }

    public void runGame() {
        setUpGame();
        // loop
        gameManager.notifyObservers();

        this.gameBoard.display();
        Scanner input = new Scanner(System.in);

        input.close();
    }
}
