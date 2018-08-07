package View;

import javax.swing.*;

public class OptionsForm extends JFrame {

    private JPanel panel1;
    private JButton playButton;
    private JButton createHeroButton;
    private JButton switchButton;

    public OptionsForm(){
        panel1.setVisible(true);
        panel1.revalidate();
        panel1.repaint();
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JButton getPlayButton(){
        return playButton;
    }

    public JButton getCreateHeroButton(){
        return createHeroButton;
    }

    public JButton getSwitchButton(){
        return switchButton;
    }
}