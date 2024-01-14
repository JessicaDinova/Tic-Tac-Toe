package Composite_Dinova;

public class GameCell implements BoardComponent {
    private char cellValue = ' ';

    public GameCell() {

    }

    public void setCellValue(char value) {
        this.cellValue = value;
    }

    @Override
    public void display() {
       System.out.print("| " + this.cellValue + " |");
    }    
}
