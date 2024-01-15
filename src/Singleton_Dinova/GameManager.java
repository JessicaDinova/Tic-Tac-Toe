package Singleton_Dinova;

import java.util.ArrayList;

import Composite_Dinova.GameBoard;
import Observer_Dinova.GameObserver;

public class GameManager {
    private static GameManager gameInstance;
    private GameBoard gameBoard;
    private ArrayList<GameObserver> observers = new ArrayList<GameObserver>();

    private GameManager() {
        gameBoard = new GameBoard(9);
    }

  public static GameManager getGameInstance() {
        if (gameInstance == null) {
            gameInstance = new GameManager();
        }
        return gameInstance;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update();
        }
    }
}
