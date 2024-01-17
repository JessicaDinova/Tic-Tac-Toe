package Decorator_Potocnak;

import Command_Potocnak.Player;

public class PlayerTurnDecorator extends BaseDecorator{

    public PlayerTurnDecorator(Player player){
        this.setPlayer(player);
    }
    
    @Override
    public void decorate() {
        String border = "+---------------------+";
        String line1 =  "|   Player " + this.getPlayer().getPlayerSymbol() + " 's turn  |";
        String line2 =  "+---------------------+";

        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
    }
}
