package Command_Potocnak;

//invoker 
public class Player {
    private Command command;

    Player(Command command){
        this.command = command;
    }

    public void makeMove() {
        this.command.move();
    }
}
