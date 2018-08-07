package Controller;

import View.HeroForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeroGuiController {

    private HeroForm heroForm;
    private JRadioButton samuraiRadioButton;
    private JRadioButton kunoichiRadioButton;
    private JRadioButton archerRadioButton;
    private JTextArea heroStatsTextField;
    private JButton backButton;
    private JButton createButton;
    private JTextField nameTextField;
    private JComboBox heroesComboBox;
    private JPanel heroPanel;
    private JPanel panel1;

    public HeroGuiController() {
        initComponents();
        initListeners();
    }

    public void showHeroWindow(){
        heroForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        heroForm.pack();
        heroForm.setVisible(true);
    }

    private void initComponents(){
        heroForm = new HeroForm();
        backButton = heroForm.getBackButton();
        createButton = heroForm.getCreateButton();
        samuraiRadioButton = heroForm.getSamuraiRadioButton();
        kunoichiRadioButton = heroForm.getKunoichiRadioButton();
        archerRadioButton = heroForm.getArcherRadioButton();
        nameTextField = heroForm.getNameTextField();
        heroStatsTextField = heroForm.getHeroStatsTextField();
        heroesComboBox = heroForm.getHeroesComboBox();
    }

    private void initListeners(){
        createButton.addActionListener(new getCreateButtonClick());
        backButton.addActionListener(new getBackButtonClick());
        samuraiRadioButton.addActionListener(new getSamuraiRadioButtonSelect());
        kunoichiRadioButton.addActionListener(new getKunoichiRadioButtonSelect());
        archerRadioButton.addActionListener(new getArcherRadioButtonSelect());
    }

    private class getCreateButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = (heroesComboBox.getSelectedItem().toString() == "Heroes")
                    ?  heroesComboBox.getSelectedItem().toString() : nameTextField.getText();
            JOptionPane.showMessageDialog(null, name);
        }
    }

    private class getBackButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            heroForm.dispose();
            OptionsGuiController optionsGuiController = new OptionsGuiController();
            optionsGuiController.showOptionsWindow();
        }
    }

    private class getSamuraiRadioButtonSelect implements ActionListener {
        String name = (nameTextField.getText().length() == 0) ? "Enter Name" : (nameTextField.getText());
        public void actionPerformed(ActionEvent e) {
            String message = "Samurai!";
            clearRadioButtons(message);
            if(samuraiRadioButton.isSelected()){
                heroStatsTextField.setText("Samurai Stats\n " +
                        "   • " + name + "\n" +
                        "   • 1     Level\n" +
                        "   • 0     Experience\n" +
                        "   • 10    Attack\n" +
                        "   • 5     Defense\n" +
                        "   • 50    Hit Points");
                heroStatsTextField.revalidate();
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }

    private class getKunoichiRadioButtonSelect implements ActionListener {
        String name = (nameTextField.getText().length() == 0) ? "Enter Name" : (nameTextField.getText());
        public void actionPerformed(ActionEvent e) {
            String message = "Kunoichi!";
            clearRadioButtons(message);
            if(kunoichiRadioButton.isSelected()) {
                heroStatsTextField.setText("Kunoichi Stats\n " +
                        "   • " + name + "\n" +
                        "   • 1     Level\n" +
                        "   • 0     Experience\n" +
                        "   • 10    Attack\n" +
                        "   • 5     Defense\n" +
                        "   • 50    Hit Points");
                heroStatsTextField.revalidate();
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }

    private class getArcherRadioButtonSelect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = (nameTextField.getText().length() == 0) ? "Enter Name" : (nameTextField.getText());
            String message = "Archer!";
            clearRadioButtons(message);
            if(archerRadioButton.isSelected()) {
                heroStatsTextField.setText("Archer Stats\n " +
                        "   • " + name + "\n" +
                        "   • 1     Level\n" +
                        "   • 0     Experience\n" +
                        "   • 10    Attack\n" +
                        "   • 5     Defense\n" +
                        "   • 50    Hit Points");
                heroStatsTextField.revalidate();
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }

    private void clearRadioButtons(String buttonName) {
        if (buttonName.equalsIgnoreCase("Samurai!")){
            if (archerRadioButton.isSelected()) archerRadioButton.doClick();
            if (kunoichiRadioButton.isSelected()) kunoichiRadioButton.doClick();
        } else if(buttonName.equalsIgnoreCase("Kunoichi!")) {
            if (archerRadioButton.isSelected()) archerRadioButton.doClick();
            if (samuraiRadioButton.isSelected()) samuraiRadioButton.doClick();
        } else if(buttonName.equalsIgnoreCase("Archer!")) {
            if (kunoichiRadioButton.isSelected()) kunoichiRadioButton.doClick();
            if (samuraiRadioButton.isSelected()) samuraiRadioButton.doClick();
        }
    }
}