package Controller;

import Model.Hero;
import View.HeroForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        List<Hero> heroes = DatabaseController.selectAll();
        for (Hero hero : heroes) {
            heroesComboBox.addItem(hero.HeroName);
        }

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
            String name = (heroesComboBox.getSelectedItem().toString() != "")
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
            if (nameTextField.getText().length() == 0) {
                String message = "Samurai!";
                clearRadioButtons(message);
                heroStatsTextField.setText("");
                if (samuraiRadioButton.isSelected()) samuraiRadioButton.doClick();
                JOptionPane.showMessageDialog(null, "Please Enter A Unique Name For Your Hero!");
            }
            else {
                String message = "Samurai!";
                clearRadioButtons(message);
                Hero hero = new Hero();
                hero.HeroName = nameTextField.getText();
                hero.HeroClass = "Samurai";
                hero.HeroHp = 100;
                hero.HeroAtt = 10;
                hero.HeroDef = 20;
                hero.HeroLvl = 0;
                hero.HeroXp = 0;
                if (samuraiRadioButton.isSelected()) {
                    heroStatsTextField.setText(nameTextField.getText() + "\n" +
                            "Samurai Stats\n " +
                            "   • 0         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 20        Defense\n" +
                            "   • 100       Hit Points");
                    heroStatsTextField.revalidate();
                    JOptionPane.showMessageDialog(null, message);
                }
                /*System.out.println(
                        nameTextField.getText() + "\n" +
                                "Samurai Stats\n " +
                                "   • " + hero.HeroLvl + "  Level\n" +
                                "   • " + hero.HeroXp + "   Experience\n" +
                                "   • " + hero.HeroAtt + "  Attack\n" +
                                "   • " + hero.HeroDef + "  Defense\n" +
                                "   • " + hero.HeroHp + "    Hit Points"
                );*/
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