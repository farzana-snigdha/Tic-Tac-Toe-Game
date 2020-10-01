import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ForestTheme implements Theme {
    Color boardColor = new Color(0x8ED750);
    Color lineColor = new Color(0x2B5706);

    public void setBoardTheme(JPanel mainPanel, JPanel gamePanel, JPanel optionPanel, JButton[] buttonList) {
        mainPanel.setBackground(boardColor);
        gamePanel.setBackground(lineColor);
        optionPanel.setBackground(boardColor);
        for (int i = 0; i < 9; i++) {
            buttonList[i].setBackground(boardColor);
        }
    }


    public void setAIButtonIcon(int j, JButton[] button) {
        setButtonIcon(button[j], "resources/ForestAIIcon.png");
    }
    public void setPlayerButtonIcon(int j, JButton[] button) {
        setButtonIcon(button[j], "resources/ForestPlayerIcon.jpg");
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
            System.out.println(ex+" forest Button");
        }
    }



}
