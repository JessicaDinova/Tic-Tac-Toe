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
        int round = 0;
        boolean endGame = false;
        this.gameManager.notifyObservers();
        while (!endGame) {
            this.gameBoard.display();
            int playerInput;

            try {
                playerInput = input.nextInt();
                this.gameManager.getCurrentPlayer().setComand(
                        new MoveCommand(this.gameBoard, playerInput, gameManager.getCurrentPlayer().getPlayerSymbol()));

                if (gameManager.canMakeMove(playerInput) && !endGame) {
                    this.gameManager.getCurrentPlayer().makeMove(playerInput);
                    this.gameManager.switchPlayer();
                    this.gameManager.notifyObservers();
                    round++;
                }
            } catch (InputMismatchException  | IndexOutOfBoundsException e) {
                if(e instanceof InputMismatchException){
                    System.out.println("Wrong input! You can only input numbers!");
                    input.next();
                }
                else if(e instanceof IndexOutOfBoundsException){
                    System.out.println("Wrong input! You can only input numbers between 1 and 9!");    
                }
            } 
            endGame = gameManager.hasGameEnded(round);
        }

        this.gameManager.notifyObservers();
        this.gameBoard.display();

        input.close();
    }
}
