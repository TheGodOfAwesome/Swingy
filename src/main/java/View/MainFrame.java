package View;

import javax.swing.*;

public class MainFrame extends JFrame {

    public static final int width = 100;
    public static final int height = 100;

    private JPanel panel;
    //git private JFrame frame;
    private JButton buttonTest;
    private JTextArea textAreaTest;

    public MainFrame(){
        setSize(width, height);
        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    public JButton getButtonTest(){
        return buttonTest;
    }

    public JTextArea getTestTextArea(){
        return textAreaTest;
    }
}
