package Composite_Dinova;

import java.util.ArrayList;
import java.util.Collections;

public class GameBoard implements BoardComponent {
    private ArrayList<BoardComponent> gameCells = new ArrayList<BoardComponent>();
    private ArrayList<Integer> allPlayedMoves = new ArrayList<Integer>();
    

    public GameBoard(int size) {
        for (int i = 0; i < size; i++) {
            gameCells.add(new GameCell());
        }
    }

    public void setCellValue(int index, char value) {
       ((GameCell) gameCells.get(index)).setCellValue(value);
    }

    public void addPlayedMove(int index) {
        this.allPlayedMoves.add(index);
        Collections.sort(allPlayedMoves);
    }

    public ArrayList<Integer> getPlayedMoves() {
        return this.allPlayedMoves;
    }

    @Override
    public void display() {
        System.out.println(" ---  ---  ---\t\t ---  ---  ---");
        for (int i = 0; i < gameCells.size(); i++) {
            ((GameCell) gameCells.get(i)).display();
            if ((i + 1) % 3 == 0 && (i < gameCells.size())) {
                System.out.print("\t\t| " + (i - 1) + " || " + i + " || " + (i + 1) + " |");
                System.out.println("\n ---  ---  ---\t\t ---  ---  ---");
            }
        }
    }

}
