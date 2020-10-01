import java.util.Random;

public class DefensiveAI implements AI {
    WinnerCheck WinnerCheck = new WinnerCheck();
    ButtonIndex buttonPosition = new ButtonIndex();


    @Override
    public ButtonIndex AIMove(String[][] buttonSymbol) {
        int finalRow, finalColumn;

        //to find an empty place
        do {
            finalRow = new Random().nextInt(3);
            finalColumn = new Random().nextInt(3);
        } while (!buttonSymbol[finalRow][finalColumn].equals("boo"));


        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (buttonSymbol[row][column].equals("boo")) {
                    buttonSymbol[row][column] = "X";
                    if (WinnerCheck.checkWinner("X", buttonSymbol)) {
                        finalRow = row;
                        finalColumn = column;
                    }
                    buttonSymbol[row][column] = "boo";
                }
            }
        }
        buttonSymbol[finalRow][finalColumn] = "0";
        buttonPosition.setRow(finalRow);
        buttonPosition.setColumn(finalColumn);

        return buttonPosition;
    }


}



