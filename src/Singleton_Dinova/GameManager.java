package Singleton_Dinova;

import java.util.ArrayList;

import Command_Potocnak.Player;
import Composite_Dinova.GameBoard;
import Factory_Potocnak.PlayerOFactory;
import Factory_Potocnak.PlayerXFactory;
import Observer_Dinova.GameEndObserver;
import Observer_Dinova.GameObserver;
import Observer_Dinova.PlayerTurnObserver;


public class GameManager {
    private static GameManager gameInstance;

    private GameBoard gameBoard;
    private ArrayList<GameObserver> observers = new ArrayList<GameObserver>();
    private Player currentPlayer;

    private PlayerOFactory playerOFactory = new PlayerOFactory();
    private PlayerXFactory playerXFactory = new PlayerXFactory();

    private Player playerO;
    private Player playerX;

    private Player winningPlayer;
    private boolean isGameOver = false;

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
            if (observer instanceof GameEndObserver) {
                observer.update(isGameOver, winningPlayer);
            }
            else if(observer instanceof PlayerTurnObserver){
                observer.update(isGameOver, currentPlayer);
            }
        }
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer.getPlayerSymbol() == 'X') ? playerO : playerX;
        notifyObservers();
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
            this.currentPlayer = this.playerO;
        } else {
            this.currentPlayer = this.playerX;
        }
    }

    public boolean hasGameEnded(int numberOfRound) {
        this.isGameOver = true;
        if (this.playerO.hasWon()) {
            this.winningPlayer = playerO;
            notifyObservers();
            return true;
        } else if (this.playerX.hasWon()) {
            this.winningPlayer = playerX;
            notifyObservers();
            return true;
        } else if (numberOfRound >= 9) {
            this.winningPlayer = null;
            notifyObservers();
            return true;
        } else {
            this.isGameOver = false;
            return false;
        }

    }

    public boolean canMakeMove(int index) {
        if (gameBoard.getPlayedMoves().contains(index)) {
            return false;
        }
        return true;
    }
}
