package Controller;

import View.OptionsForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsGuiController {

    private OptionsForm optionsForm;
    private JButton     playButton;
    private JButton     createHeroButton;
    private JButton     switchButton;

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
            int screenWidth = 1080;
            int screenHeight = 1080;
            GameGuiController gameGuiController = new GameGuiController(screenWidth, screenHeight);
            gameGuiController.showGameWindow();
        }
    }

    private class getCreateHeroButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            HeroGuiController heroGuiController = new HeroGuiController();
            heroGuiController.showHeroWindow();
            //OptionsForm.dispose();
        }
    }

    private class getSwitchButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
        }
    }
}