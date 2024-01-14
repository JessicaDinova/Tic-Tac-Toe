package Composite_Dinova;

import java.util.List;

public class GameBoard implements BoardComponent {
    private List<BoardComponent> gameCells;

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
        for (int i = 0; i < gameCells.size(); i++) {
            ((GameCell) gameCells.get(i)).display();
            if ((i + 1) % 3 == 0) {
                System.out.println("\n");
            } else {
                System.out.println("|");
            }
        }
    }

}
