import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UnitTest {
    WinnerCheck winnerCheck = new WinnerCheck();
    AI ai = new DefensiveAI();
    ButtonIndex buttonPosition;

    @Test
    void firstColumnWinnerCheckTest() {
        String[][] gameBoard = {
                {"X",  "X",   "0"},
                {"X",  "0",   "0"},
                {"X", "boo", "boo"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertTrue(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void secondColumnWinnerCheckTest() {
        String[][] gameBoard = {
                { "X",  "0", "boo"},
                { "X",  "0",  "X" },
                {"boo", "0", "boo"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("X", gameBoard));
        Assertions.assertTrue(winnerCheck.checkWinner("0", gameBoard));

    }

    @Test
    void thirdColumnWinnerCheckTest() {
        String[][] gameBoard = {
                { "X",   "X",  "0"},
                { "X",  "boo", "0"},
                {"boo", "boo", "0"}
        };
        Assertions.assertTrue(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertFalse(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void firstRowWinnerCheckTest() {
        String[][] gameBoard = {
                {"X",  "X",   "X"},
                {"X",  "0",   "0"},
                {"0", "boo", "boo"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertTrue(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void secondRowWinnerCheckTest() {
        String[][] gameBoard = {
                {"X",  "X", "boo"},
                {"0",  "0",  "0"},
                {"X", "boo", "X"}
        };
        Assertions.assertTrue(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertFalse(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void thirdRowWinnerCheckTest() {
        String[][] gameBoard = {
                {"0", "boo", "boo"},
                {"X",  "0",   "0"},
                {"X",  "X",   "X"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertTrue(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void diagonalWinnerCheckTest1() {
        String[][] gameBoard = {
                {"0", "boo", "boo"},
                {"X",  "0",   "X"},
                {"X",  "X",   "0"}
        };
        Assertions.assertTrue(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertFalse(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void diagonalWinnerCheckTest2() {
        String[][] gameBoard = {
                {"0", "boo", "X"},
                {"X",  "X",  "0"},
                {"X",  "0", "boo"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertTrue(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void WinnerCheckTest1() {
        String[][] gameBoard = {
                {"0",  "0",  "X"},
                {"X",  "X",  "0"},
                {"X",  "0",  "X"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertTrue(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void drawWinnerCheckTest1() {
        String[][] gameBoard = {
                {"0", "X", "0"},
                {"X", "X", "0"},
                {"X", "0", "X"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertFalse(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void drawWinnerCheckTest2() {
        String[][] gameBoard = {
                {"X", "0", "X"},
                {"X", "0", "0"},
                {"0", "X", "X"}
        };
        Assertions.assertFalse(winnerCheck.checkWinner("0", gameBoard));
        Assertions.assertFalse(winnerCheck.checkWinner("X", gameBoard));

    }

    @Test
    void checkDrawTest() {
        Assertions.assertFalse(winnerCheck.drawCheck(3));
        Assertions.assertTrue(winnerCheck.drawCheck(5));

    }

    @Test
    void getDefensiveAIMoveThirdColumnTest() {

        String[][] gameBoard = {
                {"boo", "boo", "boo"},
                {"boo", "boo",  "X"},
                { "0",  "boo",  "X"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(0, buttonPosition.getRow());
        Assertions.assertEquals(2, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMoveSecondColumnTest() {

        String[][] gameBoard = {
                {"boo",  "X",  "boo"},
                {"boo", "boo", "boo"},
                { "0",   "X",  "boo"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(1, buttonPosition.getRow());
        Assertions.assertEquals(1, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMove1stColumnTest() {

        String[][] gameBoard = {
                {"boo", "boo", "boo"},
                { "X",  "boo",  "0"},
                { "X",  "boo", "boo"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(0, buttonPosition.getRow());
        Assertions.assertEquals(0, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMove1stRowTest() {

        String[][] gameBoard = {
                { "X",  "boo", "X"},
                {"boo", "boo", "0"},
                {"boo",  "X",  "0"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(0, buttonPosition.getRow());
        Assertions.assertEquals(1, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMove2ndRowTest() {

        String[][] gameBoard = {
                {"boo",  "0", "boo"},
                {"boo",  "X",  "X"},
                { "0",  "boo", "X"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(1, buttonPosition.getRow());
        Assertions.assertEquals(0, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMove3rdRowTest() {

        String[][] gameBoard = {
                { "0",  "boo", "boo"},
                {"boo",  "0",   "X"},
                { "X",  "boo",  "X"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(2, buttonPosition.getRow());
        Assertions.assertEquals(1, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMoveDiagonal1Test() {

        String[][] gameBoard = {
                {"0", "boo", "boo"},
                {"X",  "X",   "0"},
                {"X",  "0",   "X"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(0, buttonPosition.getRow());
        Assertions.assertEquals(2, buttonPosition.getColumn());
    }

    @Test
    void getDefensiveAIMoveDiagonal2Test() {

        String[][] gameBoard = {
                {"boo",  "0", "boo"},
                { "X",   "X",  "0"},
                {"boo", "boo", "X"}
        };

        buttonPosition = ai.AIMove(gameBoard);
        Assertions.assertEquals(0, buttonPosition.getRow());
        Assertions.assertEquals(0, buttonPosition.getColumn());
    }

}
