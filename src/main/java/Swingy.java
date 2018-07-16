import Controller.MainFrameController;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class Swingy {

    public static void main(String[] args){
        //System.out.print("Hello World!\n");

        /*JFrame frame = new JFrame();
        JButton buttonTest = new JButton();
        //JPanel  panelTest;
        frame.setContentPane();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        buttonTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Goodbye World!");
            }
        });*/

        MainFrameController controller = new MainFrameController();
        controller.showMainFrameWindow();

        return;
    }

}
