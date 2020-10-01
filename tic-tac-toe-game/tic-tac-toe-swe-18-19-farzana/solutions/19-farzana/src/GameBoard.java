import javax.swing.*;

public class GameBoard {
    public JFrame frame;
    private JButton button00;
    private JButton button01;
    private JButton button02;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button20;
    private JButton button21;
    private JButton button22;
    private final JButton[] buttonList = new JButton[]{ button00, button01, button02,
                                                        button10, button11, button12,
                                                        button20, button21, button22
                                                        };

    public JPanel mainPanel;
    public JPanel gamePanel;
    private JPanel optionPanel;

    private JRadioButton radioButtonClassic;
    private JRadioButton radioButtonForest;
    private JRadioButton radioButtonHighContrast;

    private JButton buttonStartWithDefensiveAI;
    private JButton buttonStartWithRandomAI;

    String[][] buttonSymbol = new String[3][3];
    JButton[][] gameButton = new JButton[3][3];


    final int[] totalNumberOfMovesMade = {0};

    AI ai;
    WinnerCheck winnerCheck;
    Theme gameTheme;

    public GameBoard() {

        winnerCheck = new WinnerCheck();
        groupThemeRadioButton();
        setOptionButtonListeners();
        createFrame();
        setInitialButtonSymbol();
        lockGameBoard();
        setClassicTheme();
        makeMove();


    }

    private void setInitialButtonSymbol() {
        int k = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                gameButton[row][column] = buttonList[k++];
                buttonSymbol[row][column] = "boo";
            }
        }
    }

    private void setOptionButtonListeners() {
        radioButtonClassic.addActionListener(e -> setClassicTheme());
        radioButtonForest.addActionListener(e -> setForestTheme());
        radioButtonHighContrast.addActionListener(e -> setHighContrastTheme());
        buttonStartWithDefensiveAI.addActionListener(e -> setStartWithDefensiveAIButton());
        buttonStartWithRandomAI.addActionListener(e -> setStartWithRandomAIButton());
    }

    private void groupThemeRadioButton() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonClassic);
        buttonGroup.add(radioButtonForest);
        buttonGroup.add(radioButtonHighContrast);
    }

    private void makeMove() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                int finalColumn = column;
                int finalRow = row;
                gameButton[row][column].addActionListener(e -> {
                    playerTurn(finalColumn, finalRow);
                    if (gamePanel.isEnabled()) {
                        AITurn();
                    }

                });
            }
        }
    }

    private void AITurn() {
        ButtonIndex buttonPosition;
        buttonPosition = ai.AIMove(buttonSymbol);
        int row = buttonPosition.getRow();
        int column = buttonPosition.getColumn();
        gameButton[row][column].setEnabled(false);

        setGameTheme();
        checkGameStatus();
    }

    private void playerTurn(int column, int row) {
        buttonSymbol[row][column] = "X";
        gameButton[row][column].setEnabled(false);
        setGameTheme();
        totalNumberOfMovesMade[0]++;
        checkGameStatus();
    }


    private void createFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(mainPanel);
    }


    void lockGameBoard() {
        for (int i = 0; i < 9; i++) {
            gamePanel.getComponent(i).setEnabled(false);
        }
    }

    private void setStartWithRandomAIButton() {
        ai = new RandomAI();
        unlockGameBoard();
    }

    private void setStartWithDefensiveAIButton() {
        ai = new DefensiveAI();
        unlockGameBoard();
    }

    void setClassicTheme() {
        gameTheme = new ClassicTheme();
        radioButtonClassic.setSelected(true);
        setGameTheme();
    }

    private void setHighContrastTheme() {
        gameTheme = new HighContrastTheme();
        setGameTheme();
    }

    private void setForestTheme() {
        gameTheme = new ForestTheme();
        setGameTheme();
    }

    void setGameTheme() {
        gameTheme.setBoardTheme(mainPanel, gamePanel, optionPanel, buttonList);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {

                if (buttonSymbol[row][column].equals("X")) {
                    gameTheme.setPlayerButtonIcon(column, gameButton[row]);
                }
                if (buttonSymbol[row][column].equals("0")) {
                    gameTheme.setAIButtonIcon(column, gameButton[row]);
                }

            }
        }
    }

    void unlockGameBoard() {
        for (int i = 0; i < 9; i++) {
            gamePanel.getComponent(i).setEnabled(true);
        }
        resetGameBoard();
    }

    private void resetGameBoard() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                buttonSymbol[row][column] = "boo";
            }
        }
    }

    void checkGameStatus() {
        if (winnerCheck.checkWinner("X", buttonSymbol)) {
            announceWinner("Player won");
        } else if (winnerCheck.checkWinner("0", buttonSymbol)) {
            announceWinner("AI won");
        } else if (winnerCheck.drawCheck(totalNumberOfMovesMade[0])) {
            announceWinner("Draw");
        }
    }
    private void announceWinner(String result) {
        gamePanel.setEnabled(false);
        JOptionPane.showMessageDialog(mainPanel, result);

        frame.dispose();
        new GameBoard();
    }


}