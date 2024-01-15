package GameLoop_Dinova;

import Command_Potocnak.Player;
import Composite_Dinova.GameBoard;
import Factory_Potocnak.PlayerOFactory;
import Factory_Potocnak.PlayerXFactory;
import Singleton_Dinova.GameManager;

public class GameLoop {
    private GameManager gameManager;
    private GameBoard gameBoard;

    private PlayerOFactory playerOFactory;
    private PlayerXFactory playerXFactory;

    private Player playerO;
    private Player playerX;


    public void runGame() {
        this.gameManager = GameManager.getGameInstance();
        this.gameBoard = gameManager.getGameBoard();
        this.gameBoard.display();

        this.playerO = playerOFactory.createPlayer();
        this.playerX = playerXFactory.createPlayer();
    }
}
