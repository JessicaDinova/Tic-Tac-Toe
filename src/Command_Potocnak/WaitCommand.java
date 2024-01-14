package Command_Potocnak;

public class WaitCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Waiting for next move");    
    }
}
