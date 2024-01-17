package Observer_Dinova;

import Command_Potocnak.Player;
import Decorator_Potocnak.BaseDecorator;
import Decorator_Potocnak.GameEndDecorator;

public class GameEndObserver implements GameObserver {
    private BaseDecorator gameOverDecorator = new GameEndDecorator();

    @Override
    public void update(boolean hasGameEnded, Player player) {
        if (hasGameEnded == true && player != null) {
            gameOverDecorator.setPlayer(player);
            gameOverDecorator.decorate();
        } else if (hasGameEnded == true && player == null) {
            gameOverDecorator.setPlayer(null);
            gameOverDecorator.decorate();;
        }
    }
    
}
