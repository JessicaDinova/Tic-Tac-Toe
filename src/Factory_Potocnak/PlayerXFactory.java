package Factory_Potocnak;

import Command_Potocnak.Player;

public class PlayerXFactory extends PlayerFactory {

    @Override
    public Player createPlayer() {
        return new Player('X');
    }
    
}
