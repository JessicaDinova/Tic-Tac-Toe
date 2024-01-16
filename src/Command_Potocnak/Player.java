package Command_Potocnak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//invoker 
public class Player {
    private Command command;
    private char symbol;
    private ArrayList<Integer> playedMoves = new ArrayList<Integer>();
    private ArrayList<ArrayList<Integer>> winningCombinations = new ArrayList<ArrayList<Integer>>();

    public Player(char symbol){        
        this.symbol = symbol;

        //Horizontal winnings
        winningCombinations.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        winningCombinations.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        winningCombinations.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        //Vertical winnigs
        winningCombinations.add(new ArrayList<>(Arrays.asList(1, 4, 7)));
        winningCombinations.add(new ArrayList<>(Arrays.asList(2, 5, 8)));
        winningCombinations.add(new ArrayList<>(Arrays.asList(3, 6, 9)));
        
        //Diagonal winnings
        winningCombinations.add(new ArrayList<>(Arrays.asList(1, 5, 9)));
        winningCombinations.add(new ArrayList<>(Arrays.asList(3, 5, 7)));
    }

    public void setComand(Command comand){
        this.command = comand;
    }

    /**
     * Executes palyer movement
     * @param index where to place the player icon
     * @return true if move is valid false if move is not valid
     */
    public boolean makeMove(int index) {
        this.playedMoves.add(index);
        Collections.sort(playedMoves);
        System.out.println(this.symbol + "" + playedMoves);
        return this.command.execute();
    }

    public char getPlayerSymbol() {
        return this.symbol;
    }

    public boolean hasWon() {
    for (ArrayList<Integer> combination : winningCombinations) {
        if (playedMoves.containsAll(combination)) {
            return true;
        }
    }
    return false;
}
}
