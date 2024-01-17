package Decorator_Potocnak;

public class GameEndDecorator extends BaseDecorator{
    public GameEndDecorator(){
        
    }
    
    @Override
    public void decorate() {
        if (this.getPlayer()!= null) {
            String border = "+--------------------------+";
            String line1 = "|   Player " + this.getPlayer().getPlayerSymbol() + " has WON!!!    |";
            String line2 = "|           GG!            |";
            String line3 = "+--------------------------+";

            System.out.println(border);
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }
        else{
            String border = "+-----------------------+";
            String line1 = "|       IT IS A TIE      |";
            String line2 = "+------------------------+";
            
            System.out.println(border);
            System.out.println(line1);
            System.out.println(line2);
        }

    }
}
