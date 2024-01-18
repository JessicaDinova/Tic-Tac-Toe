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

## Behavioral
>**Observer** (notify players about the state changes(moves of the player)) -> **Jessica**

>**Command** (moves of players) -> **Simon**