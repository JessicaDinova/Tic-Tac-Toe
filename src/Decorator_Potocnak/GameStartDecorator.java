package Decorator_Potocnak;

public class GameStartDecorator extends BaseDecorator {

    public GameStartDecorator(){
        
    }
    @Override
    public void decorate() {
        String border ="+---------------------------+";
        String line1 = "|  WELCOME to Tic Tac Toe   |";
        String line2 = "|                           |";
        String line3 = "|                           |";
        String line4 = "|     Get ready to play     |";
        String line5 = "+---------------------------+";

        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
    }
}
