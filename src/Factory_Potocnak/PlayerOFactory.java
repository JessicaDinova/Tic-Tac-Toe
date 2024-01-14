package Factory_Potocnak;

import Command_Potocnak.Player;

public class PlayerOFactory extends PlayerFactory {

    @Override
    public Player createPlayer() {
        return new Player('O');
    }
    
}
