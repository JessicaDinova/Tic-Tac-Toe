package Composite_Dinova;

import java.util.ArrayList;

public class GameBoard implements BoardComponent {
    private ArrayList<BoardComponent> gameCells = new ArrayList<BoardComponent>();

    public GameBoard(int size) {
        for (int i = 0; i < size; i++) {
            gameCells.add(new GameCell());
        }
    }

    public void setCellValue(int index, char value) {
       ((GameCell) gameCells.get(index)).setCellValue(value);
    }

    @Override
    public void display() {
        System.out.println(" ---  ---  ---");
        for (int i = 0; i < gameCells.size(); i++) {
            //((GameCell) gameCells.get(i)).setCellValue('x');
            ((GameCell) gameCells.get(i)).display();
            if ((i + 1) % 3 == 0 && (i < gameCells.size())) {
                System.out.println("\n ---  ---  ---");
            }
        }
    }

}
