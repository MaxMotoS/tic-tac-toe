import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("Player1", 'x',
                "Player2", 'o');
        game.run();
    }
}
