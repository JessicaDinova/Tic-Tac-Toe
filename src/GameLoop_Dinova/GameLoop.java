package GameLoop_Dinova;

import Composite_Dinova.GameBoard;
import Singleton_Dinova.GameManager;

public class GameLoop {
    public GameManager gameManager;
    public GameBoard gameBoard;
    public void runGame() {
       this.gameManager = GameManager.getGameInstance();
        this.gameBoard = gameManager.getGameBoard();
        this.gameBoard.display();
    }
}
