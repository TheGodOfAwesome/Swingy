package Controller;

import Model.Enemy;
import Model.Hero;
import Model.Map;
import View.GameForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGuiController {

    public Hero player = new Hero();
    public Map map;
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

    GameGuiActionController gameController = new GameGuiActionController();

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
        printHeroStatus(hero);

        map = gameController.startGame(player);
        map.setGameState("gui");
        printMap(map);
    }

    private class getButtonNorthClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "North!";
            gameTextArea.setText("");
            gameController.onMove(message, map, player);
            printMap(map);
        }
    }

    private class getButtonSouthClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "South!";
            gameTextArea.setText("");
            gameController.onMove(message, map, player);
            printMap(map);
        }
    }

    private class getButtonWestClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "West!";
            gameTextArea.setText("");
            gameController.onMove(message, map, player);
            printMap(map);
        }
    }

    private class getButtonEastClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String message = "East!";
            gameTextArea.setText("");
            gameController.onMove(message, map, player);
            printMap(map);
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
            DatabaseController.updateHero(player);
            gameForm.dispose();
            OptionsGuiController optionsGuiController = new OptionsGuiController();
            optionsGuiController.showOptionsWindow();
        }
    }

    private void printHeroStatus(Hero player) {
        labelHero.setText("<html>" + player.HeroName + "<br/>"
                + player.HeroClass + "<br/>"
                + player.HeroLvl + "<br/>"
                + player.HeroHp + "<br/>"
                + player.HeroAtt + "<br/>"
                + player.HeroDef + "<br/>"
                + player.HeroXp + "<html>" );
    }

    private void printMap(Map map) {
        printHeroStatus(player);
        map.loadMap(player);
        String[][] mapLayout = map.getMapLayout();
        /*
        for(int x = 0; x < map.getMapX(); x++) {

            for(int y = 0; y < map.getMapY(); y++){
                System.out.print(mapLayout[x][y]);
            }
            System.out.println();
        }*/

        int startX = (50 - map.getMapX())/2;
        int startY = (125 - map.getMapY())/2;

        int a = - (startX);
        int b = - (startY);

        System.out.println(startX);
        System.out.println(startY);

        for(int x = 0; x < 50; x++) {
            a++;
            for(int y = 0; y < 125; y++){
                //System.out.println("x: " + x + "\ny: "+ y + "\na: " + a + "\nb: " + b);
                b++;
                if (a >= 0 && a < map.getMapX() && b > 0 && b < map.getMapY()) {
                    gameTextArea.setForeground(Color.WHITE);
                    gameTextArea.append(mapLayout[a][b]);
                }
                else {
                    gameTextArea.setForeground(Color.BLACK);
                    gameTextArea.append("X");
                }
            }
            if (x < 49)
                gameTextArea.append("\n");
            b = - (startY);
        }
    }

    public void printCurrentEnemy(Enemy monster) {
        labelEnemy.setText("<html>" + monster.getEnemyName() + "<br/>"
                + monster.getEnemyClass() + "<br/>"
                + monster.getEnemyLvl() + "<br/>"
                + monster.getEnemyHp() + "<br/>"
                + monster.getEnemyAtt() + "<br/>"
                + monster.getEnemyDef() + "<br/>"
                + monster.getEnemyXp() + "<html>" );
    }

    public void clearLabelEnemy() {
        labelEnemy.setText("");
    }


    public void closeForm(){
            gameForm.dispose();
    }

}
