package Controller;

import Model.Hero;
import View.HeroForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HeroGuiController {

    public static  Hero hero = new Hero();

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
        for(int i = 0; i < heroes.size(); i++) {
            heroesComboBox.addItem(heroes.get(i).HeroName);
        }

    }

    private void initListeners(){
        createButton.addActionListener(new getCreateButtonClick());
        backButton.addActionListener(new getBackButtonClick());
        samuraiRadioButton.addActionListener(new getSamuraiRadioButtonSelect());
        kunoichiRadioButton.addActionListener(new getKunoichiRadioButtonSelect());
        archerRadioButton.addActionListener(new getArcherRadioButtonSelect());
        heroesComboBox.addActionListener(new getHeroesComboBox());
    }

    private class getCreateButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (heroesComboBox.getSelectedIndex() != 0) {
                heroForm.dispose();
                String heroName = (String) heroesComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, heroName);
                hero = DatabaseController.selectHero(heroName);
                GameGuiController gameGuiController = new GameGuiController(1000, 1000, hero);
                gameGuiController.showGameWindow();
            } else if (archerRadioButton.isSelected() || kunoichiRadioButton.isSelected() || samuraiRadioButton.isSelected() && (heroesComboBox.getSelectedIndex() == 0)) {
                heroForm.dispose();
                DatabaseController.insertHero(hero);
                GameGuiController gameGuiController = new GameGuiController(1000, 1000, hero);
                gameGuiController.showGameWindow();
            } else {
                JOptionPane.showMessageDialog(null, "Please Give Your Hero A Name and Select A Hero Class.\n Or Select An Existing Hero!");
            }
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
        String name = nameTextField.getText();
        public void actionPerformed(ActionEvent e) {
            heroStatsTextField.setText("");
            if (nameTextField.getText().length() == 0) {
                heroStatsTextField.setText("");
                if (samuraiRadioButton.isSelected()) samuraiRadioButton.setSelected(false);
                JOptionPane.showMessageDialog(null, "Please Enter A Unique Name For Your Hero!");
            }
            else {
                String message = "Samurai!";
                clearRadioButtons(message);
                name = nameTextField.getText();
                hero.HeroName = name;
                hero.HeroClass = "Samurai";
                hero.HeroHp = 100;
                hero.HeroAtt = 10;
                hero.HeroDef = 20;
                hero.HeroLvl = 0;
                hero.HeroXp = 0;
                if (samuraiRadioButton.isSelected()) {
                    heroStatsTextField.setText(
                            nameTextField.getText() + "\n" +
                            "Samurai Stats\n " +
                            "   • 0         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 20        Defense\n" +
                            "   • 100       Hit Points");
                    heroStatsTextField.revalidate();
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        }
    }

    private class getKunoichiRadioButtonSelect implements ActionListener {
        String name = nameTextField.getText();
        public void actionPerformed(ActionEvent e) {
            heroStatsTextField.setText("");
            if (nameTextField.getText().length() == 0) {
                heroStatsTextField.setText("");
                if (kunoichiRadioButton.isSelected()) kunoichiRadioButton.setSelected(false);
                JOptionPane.showMessageDialog(null, "Please Enter A Unique Name For Your Hero!");
            }
            else {
                String message = "Kunoichi!";
                clearRadioButtons(message);
                name = nameTextField.getText();
                hero.HeroName = name;
                hero.HeroClass = "Kunoichi";
                hero.HeroHp = 100;
                hero.HeroAtt = 10;
                hero.HeroDef = 20;
                hero.HeroLvl = 0;
                hero.HeroXp = 0;
                if (kunoichiRadioButton.isSelected()) {
                    heroStatsTextField.setText(
                            nameTextField.getText() + "\n" +
                            "Kunoichi Stats\n " +
                            "   • 0         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 20        Defense\n" +
                            "   • 100       Hit Points");
                    heroStatsTextField.revalidate();
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        }
    }

    private class getArcherRadioButtonSelect implements ActionListener {
        String name = nameTextField.getText();
        public void actionPerformed(ActionEvent e) {
            heroStatsTextField.setText("");
            if (nameTextField.getText().length() == 0) {
                heroStatsTextField.setText("");
                if (archerRadioButton.isSelected()) archerRadioButton.setSelected(false);
                JOptionPane.showMessageDialog(null, "Please Enter A Unique Name For Your Hero!");
            }
            else {
                String message = "Archer!";
                clearRadioButtons(message);
                name = nameTextField.getText();
                hero.HeroName = name;
                hero.HeroClass = "Archer";
                hero.HeroHp = 100;
                hero.HeroAtt = 10;
                hero.HeroDef = 20;
                hero.HeroLvl = 0;
                hero.HeroXp = 0;
                if (archerRadioButton.isSelected()) {
                    heroStatsTextField.setText(
                            nameTextField.getText() + "\n" +
                            "Archer Stats\n " +
                            "   • 0         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 20        Defense\n" +
                            "   • 100       Hit Points");
                    heroStatsTextField.revalidate();
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        }
    }

    public class getHeroesComboBox implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (heroesComboBox.getSelectedIndex() > 0){
                if (archerRadioButton.isSelected()) archerRadioButton.setSelected(false);
                if (kunoichiRadioButton.isSelected()) kunoichiRadioButton.setSelected(false);
                if (samuraiRadioButton.isSelected()) samuraiRadioButton.setSelected(false);
                nameTextField.setText("");
                heroStatsTextField.setText("");
            }
        }
    }

    private void clearRadioButtons(String buttonName) {
        if (buttonName.equalsIgnoreCase("Samurai!")){
            if (archerRadioButton.isSelected()) archerRadioButton.setSelected(false);
            if (kunoichiRadioButton.isSelected()) kunoichiRadioButton.setSelected(false);
        } else if(buttonName.equalsIgnoreCase("Kunoichi!")) {
            if (archerRadioButton.isSelected()) archerRadioButton.setSelected(false);
            if (samuraiRadioButton.isSelected()) samuraiRadioButton.setSelected(false);
        } else if(buttonName.equalsIgnoreCase("Archer!")) {
            if (kunoichiRadioButton.isSelected()) kunoichiRadioButton.setSelected(false);
            if (samuraiRadioButton.isSelected()) samuraiRadioButton.setSelected(false);
        }
        heroesComboBox.setSelectedIndex(0);
    }
}