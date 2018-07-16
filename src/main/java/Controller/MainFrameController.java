package Controller;

import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController {
    private MainFrame mainFrame;
    private JButton buttonTest;
    private JTextArea textAreaTest;

    public MainFrameController(){
        initComponents();
        initListeners();
    }

    public void showMainFrameWindow(){
        mainFrame.setVisible(true);
    }

    private void initComponents(){
        mainFrame = new MainFrame();

        buttonTest = mainFrame.getButtonTest();
        textAreaTest = mainFrame.getTestTextArea();
    }

    private void initListeners(){
        buttonTest.addActionListener(new getTestButtonClick());
    }

    private class getTestButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Goodbye World!");
            textAreaTest.append("Goodbye World!");
        }
    }

}
