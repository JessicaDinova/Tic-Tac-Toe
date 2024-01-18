# Tic-Tac-Toe
It is simple Tic-Tac-Toe game that supports 2 players and classic 3x3 playground

The game includes the following design patterns

## Creational
> **Singleton** (managing the game state (only one instnce of the game)) -> **Jessica**

The class that is responsible for the main game logic the `GameManager` is a singelton as only one incstance of the class can exist at any givvern momenr

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

> **Factory** (instances of players X and O) -> **Simon**

Class for creating instances of the players X and O there is one base class and 2 classes that are inheriting the base class are concrete factories 

```java
public abstract class PlayerFactory {
    public abstract Player createPlayer();
}

@Override
public Player createPlayer() {
    return new Player('O');
}
```

## Structural
> **Decorator** (enhance display of the game board with messages (basic console with decorative info)) -> **Simon**
Decorator that is respnsible for additonal text in the console 

It is composed out of base class called BaseDecorator

And derived concrete classes

Main goal of the decorator is to execute additional prints to the standart input 

Such is player's turn on game winning messages

```java 
public class BaseDecorator {
    private Player player = null;

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void decorate(){};
}


    public GameStartDecorator(){
        
    }
    @Override
    public void decorate() {
        String border ="+---------------------------+";
        String line1 = "|  WELCOME to Tic Tac Toe   |";
        String line2 = "|                           |";
        String line3 = "|                           |";
        String line4 = "|     Get ready to play     |";
        String line5 = "+---------------------------+";

        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
    }
}
```


>**Composite**(representing the game board and individual cells) -> **Jessica**
Composite has the three structure where leaf is a single game cell and the whole tree is the Game bord 

```java
public class GameBoard implements BoardComponent {
    private ArrayList<BoardComponent> gameCells = new ArrayList<BoardComponent>();
    

    public GameBoard(int size) {
        for (int i = 0; i < size; i++) {
            gameCells.add(new GameCell());
        }
    }
```


## Behavioral
>**Observer** (notify players about the state changes(moves of the player)) -> **Jessica**
Observer design pattern is observing changes made to different objects in the game or game state itself 

It will notify all of the subscirbes such as playe and game board about certain changes 

It is composed of the interface and derived classes 

```java
public interface GameObserver {
    public void update(boolean hasGameEnded, Player player);
}
```

```java
@Override
public void update(boolean hasGameEnded, Player player) {
    if (!hasGameEnded) {
        this.currentPlayer = player;
        turnDecorator.setPlayer(this.currentPlayer);
        turnDecorator.decorate();
    }
}
```

>**Command** (moves of players) -> **Simon**

Command is responsible for executing palyer movements it can do player movement withing itself 

It is composed out of the base interface 'Command'
and concret classes derive from this interface 


The invoker is the player class as it is a player who is making the moves, hence executing move commnad

```java
public interface Command {
    public void execute();
}
```

```java
@Override
public void execute() {
    this.gameBoard.addPlayedMove(index);
    gameBoard.setCellValue(index-1, playerSymbol);       
}
```