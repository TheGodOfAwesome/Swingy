package View;

import javax.swing.*;
import java.awt.*;

public class GameForm extends JFrame{

    private JPanel panel;
    private JButton buttonNorth;
    private JButton buttonSouth;
    private JButton buttonWest;
    private JButton buttonEast;
    private JTextArea textArea1;
    private JButton backButton;

    public GameForm(int width, int height){
        panel.setPreferredSize(new Dimension(width, height));
        panel.revalidate();
        panel.repaint();
        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    public JButton getBackButton(){
        return backButton;
    }

    public JButton getButtonNorth(){
        return buttonNorth;
    }

    public JButton getButtonSouth(){
        return buttonSouth;
    }

    public JButton getButtonWest(){
        return buttonWest;
    }

    public JButton getButtonEast(){
        return buttonEast;
    }

    public JTextArea getGameTextArea(){
        return textArea1;
    }
}
