package Controller;

import Model.Hero;
import View.OptionsForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsGuiController {

    private OptionsForm optionsForm;
    private JButton     playButton;
    private JButton     createHeroButton;
    private JButton     switchButton;
    private Hero        hero = new Hero();

    public OptionsGuiController() {
        initComponents();
        initListeners();
    }

    public void showOptionsWindow(){
        optionsForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsForm.pack();
        optionsForm.setVisible(true);
    }

    private void initComponents(){
        optionsForm = new OptionsForm();
        playButton = optionsForm.getPlayButton();
        createHeroButton = optionsForm.getCreateHeroButton();
        switchButton = optionsForm.getSwitchButton();
    }

    private void initListeners(){
        playButton.addActionListener(new getPlayButtonClick());
        createHeroButton.addActionListener(new getCreateHeroButtonClick());
        switchButton.addActionListener(new getSwitchButtonClick());
    }

    private class getPlayButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            HeroGuiController heroGuiController = new HeroGuiController();
            heroGuiController.showHeroWindow();
            optionsForm.setVisible(false);
        }
    }

    private class getCreateHeroButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            HeroGuiController heroGuiController = new HeroGuiController();
            heroGuiController.showHeroWindow();
            optionsForm.setVisible(false);
        }
    }

    private class getSwitchButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
        }
    }
}