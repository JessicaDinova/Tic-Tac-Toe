package GameLoop_Dinova;

import Singleton_Dinova.GameManager;

public class GameLoop {
    public GameManager gameManager;

    public void runGame() {
       this.gameManager = GameManager.getGameInstance();
    }
}
