package Command_Potocnak;

import Composite_Dinova.GameBoard;

//concrate comand class
public class MoveCommand implements Command{

    private GameBoard gameBoard;
    private int index;
    private char playerSymbol;


    public MoveCommand(GameBoard gameBoard, int index, char playerSymbol){
        this.gameBoard = gameBoard;
        this.index = index;
        this.playerSymbol = playerSymbol;
    }
    
    @Override
    public void execute() {
        this.gameBoard.addPlayedMove(index);
        gameBoard.setCellValue(index-1, playerSymbol);
            
    }
    
}
