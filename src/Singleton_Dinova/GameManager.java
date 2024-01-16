package Singleton_Dinova;

import java.util.ArrayList;

import Command_Potocnak.Player;
import Composite_Dinova.GameBoard;
import Factory_Potocnak.PlayerOFactory;
import Factory_Potocnak.PlayerXFactory;
import Observer_Dinova.GameObserver;

public class GameManager {
    private static GameManager gameInstance;
    
    private GameBoard gameBoard;
    private ArrayList<GameObserver> observers = new ArrayList<GameObserver>();
    private Player currentPlayer;

    private PlayerOFactory playerOFactory = new PlayerOFactory();
    private PlayerXFactory playerXFactory = new PlayerXFactory();

    private Player playerO;
    private Player playerX;

    private GameManager() {
        pickStartingPlayer();
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
            observer.update(currentPlayer);
            observer.update();
        }
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer.getPlayerSymbol() == 'X') ? playerO : playerX;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player setPlayer) {
        this.currentPlayer = setPlayer;
    }

    private void pickStartingPlayer() {
        this.playerO = playerOFactory.createPlayer();
        this.playerX = playerXFactory.createPlayer();
        long startingPlayerIndex = Math.round(Math.random());
        if (startingPlayerIndex == 0) {
            this.currentPlayer = playerOFactory.createPlayer();
        }
        this.currentPlayer = playerXFactory.createPlayer();
    }
}
