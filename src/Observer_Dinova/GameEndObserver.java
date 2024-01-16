package Observer_Dinova;

import Command_Potocnak.Player;

public class GameEndObserver implements GameObserver {

    @Override
    public void update(boolean hasGameEnded, Player player) {
        if (hasGameEnded == true && player != null) {
            System.out.println("Player" + player.getPlayerSymbol() + "has WON GG");
        } else if (hasGameEnded == true && player == null) {
            System.out.println("Game over! It's a tie!");
        }
    }
    
}
