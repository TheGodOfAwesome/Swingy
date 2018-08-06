package Controller;

import View.GameForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiGameController {

    private GameForm gameForm;
    private JButton buttonNorth;
    private JButton buttonSouth;
    private JButton buttonWest;
    private JButton buttonEast;
    private JTextArea gameTextArea;

    public GuiGameController(int width, int height){
        initComponents(width, height);
        initListeners();
    }

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
        gameTextArea = gameForm.getGameTextArea();
    }

    private void initListeners(){
        buttonNorth.addActionListener(new getTestButtonNorthClick());
        buttonSouth.addActionListener(new getTestButtonSouthClick());
        buttonWest.addActionListener(new getTestButtonWestClick());
        buttonEast.addActionListener(new getTestButtonEastClick());
    }

    private class getTestButtonNorthClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "North!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
        }
    }

    private class getTestButtonSouthClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "South!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
        }
    }

    private class getTestButtonWestClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "West!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
        }
    }

    private class getTestButtonEastClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "East!";
            JOptionPane.showMessageDialog(null, message);
            gameTextArea.append(message + "\n");
        }
    }
}
