import java.util.Random;

public class RandomAI implements AI {


    ButtonIndex buttonPosition = new ButtonIndex();

    @Override
    public ButtonIndex AIMove(String[][] buttonSymbol) {
        int row = new Random().nextInt(3);
        int column = new Random().nextInt(3);
        if (buttonSymbol[row][column].equals("boo")) {
        //    System.out.println(row + "   " + column);
            buttonSymbol[row][column] = "0";
            buttonPosition.setRow(row);
            buttonPosition.setColumn(column);
        } else AIMove(buttonSymbol);
        return buttonPosition;
    }

}
