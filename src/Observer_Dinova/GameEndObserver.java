package Observer_Dinova;

public class GameEndObserver implements GameObserver {

    @Override
    public void update() {
        System.out.println("Game Over");
    }
    
}
