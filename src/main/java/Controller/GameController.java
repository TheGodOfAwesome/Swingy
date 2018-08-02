package Controller;

import View.GameForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

    private GameForm gameForm;
    private JButton button1;
    private JButton button2;
    private JTextArea gameTextArea;

    public GameController(int width, int height){
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
        button1 = gameForm.getButton1();
        button2 = gameForm.getButton2();
        gameTextArea = gameForm.getGameTextArea();
    }

    private void initListeners(){
        button1.addActionListener(new getTestButton1Click());
        button2.addActionListener(new getTestButton2Click());
    }

    private class getTestButton1Click implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Hello World!");
            gameTextArea.append("Hello World!\n");
        }
    }

    private class getTestButton2Click implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Goodbye World!");
            gameTextArea.append("Goodbye World!\n");
        }
    }
}
