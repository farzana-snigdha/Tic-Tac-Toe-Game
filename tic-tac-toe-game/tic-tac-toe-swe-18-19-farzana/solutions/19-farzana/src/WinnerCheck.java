public class WinnerCheck {
   boolean checkWinner(String move, String[][] symbol) {
        if (rowAndColumnCheck(move, symbol)) return true;
        return diagonalCheck(move, symbol);
    }

    private boolean rowAndColumnCheck(String move, String[][] symbol) {
        for (int i = 0; i < 3; i++) {
            if ((symbol[i][0].equals(move)) && (symbol[i][1].equals(move)) && (symbol[i][2].equals(move))) {
                return true;
            } else if ((symbol[0][i].equals(move)) && (symbol[1][i].equals(move)) && (symbol[2][i].equals(move))) {
                return true;
            }
        }
        return false;
    }

    private boolean diagonalCheck(String move, String[][] symbol) {
        if (((symbol[0][0].equals(move)) && (symbol[1][1].equals(move)) && (symbol[2][2].equals(move))) ) {
            return true;
        }
        else return (symbol[0][2].equals(move)) && (symbol[1][1].equals(move)) && (symbol[2][0].equals(move));
    }

    boolean drawCheck(int count) {
        return count == 5;
    }

}
