package View;

import javax.swing.*;

public class HeroForm extends JFrame {
    private JRadioButton samuraiRadioButton;
    private JRadioButton kunoichiRadioButton;
    private JRadioButton archerRadioButton;
    private JTextArea heroStatsTextField;
    private JButton createButton;
    private JTextField nameTextField;
    private JPanel heroPanel;
    private JPanel panel1;
    private JButton backButton;
    private JComboBox heroesComboBox;

    public HeroForm() {
        panel1.setVisible(true);
        panel1.revalidate();
        panel1.repaint();
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }


    public JButton getBackButton() {
        return backButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JRadioButton getArcherRadioButton() {
        return archerRadioButton;
    }

    public JRadioButton getKunoichiRadioButton() {
        return kunoichiRadioButton;
    }

    public JRadioButton getSamuraiRadioButton() {
        return samuraiRadioButton;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextArea getHeroStatsTextField() {
        return heroStatsTextField;
    }

    public JComboBox getHeroesComboBox() { return heroesComboBox; }
}