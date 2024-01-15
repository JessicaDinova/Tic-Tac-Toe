package Observer_Dinova;

import Command_Potocnak.Player;

public class GameEndObserver implements GameObserver {

    @Override
    public void update() {
        System.out.println("Game Over");
    }

    @Override
    public void update(Player player) {

    }
    
}
