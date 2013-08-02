public class Field {
    public static final char EMPTY_CELL = ' ';

    public static final int WIDTH = 3;
    public static final int HEIGHT = 3;
    private char[][] field;

    public Field() {
        fillField(EMPTY_CELL);
    }

    private void fillField(char value) {
        field = new char[HEIGHT][];
        for (int i = 0; i < HEIGHT; i++) {
            field[i] = fillLine(value);
            continue;
        }
    }

    private char[] fillLine(char value) {
        char[] line = new char[WIDTH];
        for (char cell : line) {
            cell = value;
        }
        return line;
    }

    public char checkWin() {
        char result;
        if ((result = checkWinDiagonals()) == EMPTY_CELL) {
            if ((result = checkWinLines()) == EMPTY_CELL) {
                if ((result = checkWinColums()) == EMPTY_CELL) { }
            }
        }
        return result;
    }

    private char checkWinDiagonals () {
        char result = EMPTY_CELL;
//      Main diagonal
        for (int i = 0, j = 0; i < HEIGHT - 1 && j < WIDTH - 1; i++, j++) {
            if (field[i][j] == field[i + 1][j + 1]) {
                result = field[i][j];
            } else {
                result = EMPTY_CELL;
                break;
            }
        }
//      more diagonal
        for (int i = 0, j = WIDTH - 1; i < HEIGHT - 1 && j > 0; i++, j--) {
            if (field[i][j] == field[i + 1][j - 1]) {
                result = field[i][j];
            } else {
                result = EMPTY_CELL;
                break;
            }
        }
        return result;
    }

    private char checkWinLines() {
        char result = EMPTY_CELL;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH - 1; j++) {
                if (field[i][j] == field[i][j + 1]) {
                    result = field[i][j];
                } else {
                    result = EMPTY_CELL;
                    break;
                }
            }
        }
        return result;
    }

    private char checkWinColums() {
        char result = EMPTY_CELL;
        for (int j = 0; j < WIDTH; j++) {
            for (int i = 0; i < HEIGHT - 1; i++) {
                if (field[i][j] == field[i + 1][j]) {
                    result = field[i][j];
                } else {
                    result = EMPTY_CELL;
                    break;
                }
            }
        }
        return result;
    }

    public void showField() {
        for (char[] line : field) {
            showFieldLine(line);
        }
    }

    private void showFieldLine(char[] line) {
        for (char cell : line) {
            System.out.print("[" + cell + "]");
        }
        System.out.println();
    }

    public void setCell(char value, int position) {
        int line = position / HEIGHT;
        int colum = position % HEIGHT;

        field[line][colum] = value;
    }
}
