package Decorator_Potocnak;

import Command_Potocnak.Player;

public class BaseDecorator {
    private Player player = null;

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void decorate(){};
}
