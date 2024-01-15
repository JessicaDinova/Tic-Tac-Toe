package Observer_Dinova;

import Command_Potocnak.Player;

public class PlayerTurnObserver implements GameObserver {
    private Player currentPlayer;

    public PlayerTurnObserver(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void update() {
        System.out.println("Player" + currentPlayer.getPlayerSymbol() + "'s turn");
    }
    
}
