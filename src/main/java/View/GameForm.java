package View;

import javax.swing.*;
import java.awt.*;

public class GameForm extends JFrame{

    private JPanel panel;
    private JButton button1;
    private JButton button2;
    private JTextArea textArea1;

    public GameForm(int width, int height){
        panel.setPreferredSize(new Dimension(width, height));
        panel.revalidate();
        panel.repaint();
        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    public JButton getButton1(){
        return button1;
    }

    public JButton getButton2(){
        return button2;
    }

    public JTextArea getGameTextArea(){
        return textArea1;
    }
}
