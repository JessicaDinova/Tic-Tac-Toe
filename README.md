# Tic-Tac-Toe 

## Design Patterns Overview
This Tic-Tac-Toe game is a simple yet well-structured application that incorporates several design patterns to enhance its organization and flexibility. We have decided to use the following design patterns

## Creational


### Singleton (Jessica)

The Singleton pattern ensures that there is only one instance of the `GameManager` class at any given time. This is achieved by having a private constructor and a static method `getGameInstance` that returns the existing instance or creates a new one if none exists.

This ensures that there is only one game active at any given moment

```java
private GameManager() {
    pickStartingPlayer();
    gameBoard = new GameBoard(9);
}

public static GameManager getGameInstance() {
    if (gameInstance == null) {
        gameInstance = new GameManager();
    }
    return gameInstance;
}
```

### Factory (Simon)

The Factory pattern is implemented through the `PlayerFactory` and its concrete subclasses (`PlayerXFactory` and `PlayerOFactory`). It provides a way to create instances of players X and O.

```java
public abstract class PlayerFactory {
    public abstract Player createPlayer();
}

public class PlayerXFactory extends PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Player('X');
    }
}
```

## Structural

### Decorator (Simon)

The Decorator pattern enhances the display of the game board by adding additional text messages. The `BaseDecorator` serves as the base class, and concrete decorators, like `GameStartDecorator`, add specific information to the console output.

```java
public class BaseDecorator {
    
}

public class GameStartDecorator extends BaseDecorator {
        @Override
    public void decorate() {
        if (this.getPlayer()!= null) {
            String border = "+--------------------------+";
            String line1 = "|   Player " + this.getPlayer().getPlayerSymbol() + " has WON!!!    |";
            String line2 = "|           GG!            |";
            String line3 = "+--------------------------+";

            System.out.println(border);
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }
        else{
            String border = "+-----------------------+";
            String line1 = "|       IT IS A TIE      |";
            String line2 = "+------------------------+";
            
            System.out.println(border);
            System.out.println(line1);
            System.out.println(line2);
        }

    }
}
```

### Composite (Jessica)

The Composite pattern is employed to represent the game board and individual cells. The `GameBoard` class acts as the composite, containing an `ArrayList` of `GameCells`, allowing for a unified treatment of both individual cells and the entire board. With the single draw call

```java
public class GameBoard implements BoardComponent {
    private ArrayList<BoardComponent> gameCells = new ArrayList<BoardComponent>();
}

@Override
public void display() {
    System.out.print("| " + this.cellValue + " |");
} 
```

## Behavioral

### Observer (Jessica)

The Observer pattern is used to notify players about state changes, such as moves made by other players. The `GameObserver` interface is implemented by both players and the game board, ensuring that they are notified of relevant changes.

```java
public interface GameObserver {
    public void update(boolean hasGameEnded, Player player);
}

@Override
public void update(boolean hasGameEnded, Player player) {
    if (hasGameEnded == true && player != null) {
        gameOverDecorator.setPlayer(player);
        gameOverDecorator.decorate();
    } else if (hasGameEnded == true && player == null) {
        gameOverDecorator.setPlayer(null);
        gameOverDecorator.decorate();;
    }
}
```

### Command (Simon)

The Command pattern handles player moves, encapsulating each move as a command. That can be exectued by themselfs

```java
public interface Command {
    public void execute();
}

public class MoveCommand implements Command {
    @Overwrite
    public void execute() {
        this.gameBoard.addPlayedMove(index);
        gameBoard.setCellValue(index-1, playerSymbol);  
    }
}
```

