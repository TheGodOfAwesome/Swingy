package Controller;

import Model.Hero;
import View.GameForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGuiController {

    public Hero player = new Hero();
    private GameForm gameForm;
    private JButton buttonNorth;
    private JButton buttonSouth;
    private JButton buttonWest;
    private JButton buttonEast;
    private JButton backButton;
    private JButton saveButton;
    private JTextArea gameTextArea;
    private JLabel labelHero;
    private JLabel labelEnemy;

    GameActionController gameController = new GameActionController();

    public void showGameWindow(){
        gameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameForm.pack();
        gameForm.setVisible(true);
    }

    private void initComponents(int width, int height){
        gameForm = new GameForm(width, height);
        buttonNorth = gameForm.getButtonNorth();
        buttonSouth = gameForm.getButtonSouth();
        buttonWest = gameForm.getButtonWest();
        buttonEast = gameForm.getButtonEast();
        backButton = gameForm.getBackButton();
        saveButton = gameForm.getSaveButton();
        gameTextArea = gameForm.getGameTextArea();
        labelHero = gameForm.getLabelHero();
        labelEnemy = gameForm.getLabelEnemy();
    }

    private void initListeners(){
        buttonNorth.addActionListener(new getButtonNorthClick());
        buttonSouth.addActionListener(new getButtonSouthClick());
        buttonWest.addActionListener(new getButtonWestClick());
        buttonEast.addActionListener(new getButtonEastClick());
        backButton.addActionListener(new getBackButtonClick());
        saveButton.addActionListener(new getSaveButtonClick());
    }


    public GameGuiController(int width, int height, Hero hero){
        player = hero;
        initComponents(width, height);
        initListeners();
        labelHero.setText("<html>" + player.HeroName + "<br/>"
                + player.HeroClass + "<br/>"
                + player.HeroLvl + "<br/>"
                + player.HeroHp + "<br/>"
                + player.HeroAtt + "<br/>"
                + player.HeroDef + "<br/>"
                + player.HeroXp + "<html>" );

        gameController.startGame(player);
    }

    private class getButtonNorthClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "North!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
            labelHero.setText("North \nNorth \nNorth \nNorth");
            labelEnemy.setText("North \nNorth \nNorth \nNorth");
        }
    }

    private class getButtonSouthClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "South!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
            labelHero.setText("South \nSouth \nSouth \nSouth");
            labelEnemy.setText("South \nSouth \nSouth \nSouth");
        }
    }

    private class getButtonWestClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "West!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
            labelHero.setText("<html>West<br/>West<br/>West<br/>West<html>");
            labelEnemy.setText("<html>West<br/>West<br/>West<br/>West<html>");
        }
    }

    private class getButtonEastClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "East!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
            labelHero.setText("East \nEast \nEast \nEast");
            labelEnemy.setText("East \nEast \nEast \nEast");
        }
    }

    private class getBackButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gameForm.dispose();
            OptionsGuiController optionsGuiController = new OptionsGuiController();
            optionsGuiController.showOptionsWindow();
        }
    }

    private class getSaveButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gameForm.dispose();
            OptionsGuiController optionsGuiController = new OptionsGuiController();
            optionsGuiController.showOptionsWindow();
        }
    }
}
