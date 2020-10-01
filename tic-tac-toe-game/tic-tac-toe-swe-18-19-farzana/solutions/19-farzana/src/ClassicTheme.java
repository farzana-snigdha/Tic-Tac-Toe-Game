import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme {
    Color boardColor = new Color(0xFFFFFF);
    Color lineColor = new Color(0x000000);

    public void setBoardTheme(JPanel mainPanel, JPanel gamePanel, JPanel optionPanel, JButton[] buttonList) {
        mainPanel.setBackground(boardColor);
        gamePanel.setBackground(lineColor);
        optionPanel.setBackground(boardColor);
        for (int i = 0; i < 9; i++) {
            buttonList[i].setBackground(boardColor);
        }
    }
    public void setAIButtonIcon(int j, JButton[] button) {
        setButtonIcon(button[j], "resources/ClassicAIIcon.png");
    }
    public void setPlayerButtonIcon(int j, JButton[] button) {
        setButtonIcon(button[j], "resources/ClassicPlayerIcon.png");
    }

    private void setButtonIcon(JButton jButton, String imageName) {
        jButton.setBackground(boardColor);
        setButtonImage(jButton, imageName);
    }

    private void setButtonImage(JButton button1, String imageName) {
        try {

            Image img = ImageIO.read(getClass().getResource(imageName));
            ImageIcon imageIcon = new ImageIcon(img);
            button1.setIcon(imageIcon);
            button1.setDisabledIcon(imageIcon);

        } catch (Exception ex) {
            System.out.println(ex+" classic Button");
        }
    }
}
