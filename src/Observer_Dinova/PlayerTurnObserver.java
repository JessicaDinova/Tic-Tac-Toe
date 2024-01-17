package Observer_Dinova;

import Command_Potocnak.Player;
import Decorator_Potocnak.BaseDecorator;
import Decorator_Potocnak.PlayerTurnDecorator;

public class PlayerTurnObserver implements GameObserver {
    private Player currentPlayer;
    private BaseDecorator turnDecorator;

    public PlayerTurnObserver(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.turnDecorator = new PlayerTurnDecorator(this.currentPlayer); 
    }

    
    @Override
    public void update(boolean hasGameEnded, Player player) {
        if (!hasGameEnded) {
            this.currentPlayer = player;
            turnDecorator.setPlayer(this.currentPlayer);
            turnDecorator.decorate();
        }
    }
    
}
