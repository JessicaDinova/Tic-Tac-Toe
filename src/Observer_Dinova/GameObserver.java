package Observer_Dinova;

import Command_Potocnak.Player;

public interface GameObserver {
    public void update(boolean hasGameEnded, Player player);
}
