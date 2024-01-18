package Decorator_Potocnak;

public class GameStartDecorator extends BaseDecorator {

    public GameStartDecorator(){
        
    }
    @Override
    public void decorate() {
        String border ="     +---------------------------+";
        String line1 = "     |  WELCOME to Tic Tac Toe   |";
        String line2 = "     |                           |";
        String line3 = "     |    To play enter number   |";
        String line4 = "     |    between 1-9 as shown   |";
        String line5 = "     |    on the right board     |";
        String line6 = "     |                           |";
        String line7 = "     |     Get ready to play     |";
        String line8 = "     +---------------------------+";

        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
    }
}
