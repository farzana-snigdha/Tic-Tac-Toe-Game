import javax.swing.*;

interface Theme {

    void setBoardTheme(JPanel mainPanel, JPanel gamePanel, JPanel optionPanel, JButton[] buttonList);

    void setAIButtonIcon(int j, JButton[] button);

    void setPlayerButtonIcon(int j, JButton[] button);


}
