import javax.swing.*;
import java.awt.*;

public class HighContrastTheme implements Theme {
    Color boardColor = new Color(0x3E403D);
    Color lineColor = new Color(0x9FA59A);
    Color HighContrastAIIcon=Color.white;
    Color HighContrastPlayerIcon=Color.black;
    
    public void setBoardTheme(JPanel mainPanel, JPanel gamePanel, JPanel optionPanel, JButton[] buttonList) {
        mainPanel.setBackground(boardColor);
        gamePanel.setBackground(lineColor);
        optionPanel.setBackground(boardColor);
        for (int i = 0; i < 9; i++) {
            buttonList[i].setBackground(boardColor);
        }
    }

    public void setAIButtonIcon(int j, JButton[] button) {
        setButtonIcon(button[j], HighContrastAIIcon);
    }

    public void setPlayerButtonIcon(int j, JButton[] button) {
        setButtonIcon(button[j], HighContrastPlayerIcon);
    }

    private void setButtonIcon(JButton jButton, Color color) {
        jButton.setIcon(null);
        jButton.setBackground(color);
    }


}
