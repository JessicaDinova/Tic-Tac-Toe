import Composite_Dinova.GameBoard;
import Singleton_Dinova.GameManager;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        GameManager gameManager;// = GameManager.getGameInstance();
        try (gameManager = GameManager.getGameInstance()) {
            GameBoard gameBoard = gameManager.getGameBoard();
            gameBoard.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}