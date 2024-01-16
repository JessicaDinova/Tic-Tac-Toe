package Observer_Dinova;

import Command_Potocnak.Player;

public class PlayerTurnObserver implements GameObserver {
    private Player currentPlayer;

    public PlayerTurnObserver(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    
    @Override
    public void update(boolean hasGameEnded, Player player) {
        if (!hasGameEnded) {
            this.currentPlayer = player;
            System.out.println("Player" + this.currentPlayer.getPlayerSymbol() + " 's turn");
        }
    }
    
}
