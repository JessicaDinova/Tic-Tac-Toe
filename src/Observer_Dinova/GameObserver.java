package Observer_Dinova;

import Command_Potocnak.Player;

public interface GameObserver {
    public void update();
    public void update(Player player);
}
