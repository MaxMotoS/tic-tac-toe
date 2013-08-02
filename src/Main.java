import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game("Player1", 'x',
                "Player2", 'o');
        game.run();
    }
}
