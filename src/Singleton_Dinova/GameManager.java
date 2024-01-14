package Singleton_Dinova;

import Composite_Dinova.GameBoard;

public class GameManager {
    private static GameManager gameInstance = null;
    private GameBoard gameBoard;

    private GameManager() {
        gameBoard = new GameBoard(3);
    }

  static GameManager getGameInstance() {
        if (gameInstance == null) {
            gameInstance = new GameManager();
        }
        return gameInstance;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
