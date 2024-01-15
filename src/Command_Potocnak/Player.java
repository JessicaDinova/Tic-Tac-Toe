package Command_Potocnak;

//invoker 
public class Player {
    private Command command;
    private char symbol;

    public Player(char symbol){        
        this.symbol = symbol;
    }

    public void setComand(Command comand){
        this.command = comand;
    }

    public void makeMove() {
        System.out.println("Player" + this.symbol + "is making move");
        this.command.execute();
    }

    public char getPlayerSymbol() {
        return this.symbol;
    }
}
