import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Game {
    private Player player1;
    private Player player2;
    private Field field;
    private Player current;

    public Game (String name1, char figure1,
                 String name2, char figure2) {
        player1 = new Player(name1, figure1);
        player2 = new Player(name2, figure2);
        field = new Field();
    }

    public void run() {
        if (player1 != null && player2 != null) {
            current = player1;
            while (true) {
                step();
                if (isEndGame()) {
                    break;
                }
            }
        }
    }

    private void step () {
        field.showField();
        System.out.println("Current player " + current.getName());
        int position = readStep();
        try {
            field.setCell(current.getFigure(), position);
        } catch (Exception e) {
            System.out.println("This cell isn't empty. Try again...");
            return;
        }
        if (current.equals(player1)) {
            current = player2;
        } else {
            current = player1;
        }
    }

    private int readStep() {
        DataInputStream in = new DataInputStream(System.in);
        int line = 0;
        int colum = 0;

        while(true) {
            System.out.print("Enter line: ");
            try {
                line = Integer.parseInt(new DataInputStream(System.in).readLine());
            } catch (Exception e) {
                System.out.println("You enter not valid colum. Try again...");
                continue;
            }
            if (line > 0 && line <= Field.HEIGHT) {
                break;
            } else {
                System.out.println("You enter not valid line. Try again...");
            }
        }
        while (true) {
            System.out.print("Enter colum: ");
            try {
                colum = Integer.parseInt(new DataInputStream(System.in).readLine());
            } catch (Exception e) {
                System.out.println("You enter not valid colum. Try again...");
                continue;
            }
            if (colum > 0 && colum <= Field.HEIGHT) {
                break;
            } else {
                System.out.println("You enter not valid colum. Try again...");
            }
        }
        return (line-1) * Field.HEIGHT + (colum - 1);
    }

    private boolean isEndGame() {
        char winFigure = field.checkWin();
        if (winFigure == Field.EMPTY_CELL) {
            return false;
        } else if (player1.getFigure() == winFigure) {
            System.out.println("Win " + player1.getName());
        } else if (player2.getFigure() == winFigure) {
            System.out.println("Win " + player2.getName());
        }
        return true;
    }
}
