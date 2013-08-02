public class Player {
    public static final String DEFAULT_NAME = "Player";
    private final String name;
    private int score = 0;
    private char figure;

    public Player(String name, char figure) {
        if (name != "") {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME + figure;
        }
        this.figure = figure;
    }

    public void IncScore() {
        this.score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public char getFigure() {
        return figure;
    }
}
