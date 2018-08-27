package Controller;

import Model.Enemy;
import Model.Hero;
import Model.Map;
import View.GameForm;

import javax.swing.*;
import java.util.Random;

public class GameGuiActionController {

    Map map;
    Random rand = new Random();
    private JLabel labelEnemy;

    public Map startGame(Hero hero) {
        map = new Map(hero);
        return map;
    }

    public void fight(Hero player, Enemy monster, String viewType) {
        JOptionPane.showMessageDialog(null, "Fight fight fight!!!" );
        GameGuiController guiController = new GameGuiController(1000, 1000, player);
        guiController.printCurrentEnemy(monster);
        int turn = 0;
        while (player.getHeroHp() > 0 && monster.getEnemyHp() > 0) {
            if (turn == 0) {
                int damage = player.getHeroAtt() - monster.getEnemyDef();
                if (damage <= 0)
                    damage = 1;
                monster.setEnemyHp(monster.getEnemyHp() - damage);
                if(viewType.equalsIgnoreCase("gui"))
                    JOptionPane.showMessageDialog(null, monster.getEnemyName() + " takes " + damage + " damage!");
                if(monster.getEnemyHp() == 0) {
                    JOptionPane.showMessageDialog(null,monster.getEnemyName() + " died!" );
                    map.removeEnemy(monster);
                    guiController.clearLabelEnemy();
                    addArtefact(player);
                    levelUp(player);
                }
                turn = 1;
            } else if(turn == 1) {
                int damage = monster.getEnemyAtt() - player.getHeroDef();
                if (damage <= 0)
                    damage = 1;
                player.setHeroHp(player.getHeroHp() - damage);
                if(viewType.equalsIgnoreCase("gui"))
                    JOptionPane.showMessageDialog(null, player.getHeroName() + " takes " + damage + " damage!" );
                if(player.getHeroHp() == 0) {
                    gameOver(player);
                }
                turn = 0;
            }
        }
    }

    public void run(Map map, Hero hero, Enemy enemy) {
        JOptionPane.showMessageDialog(null, "Your 'hero' is trying to run!!!" );
        boolean run =  rand.nextBoolean();
        if (run == true){
            fight(hero, enemy, map.getGameState());
        } else {
            JOptionPane.showMessageDialog(null, "Your 'hero' is running!!!" );
            map.setPlayerX(map.getPreviousPlayerX());
            map.setPlayerY(map.getPreviousPlayerY());
        }
    }

    public void levelUp(Hero player) {
        int currentlevel = player.getHeroLvl();
        int level = currentlevel + 1;
        int xp = player.getHeroXp();
        int xpToNxtLevel = (level * 1000) + (level - (1 * 2450));
        if (xp == xpToNxtLevel) {
            player.setHeroLvl(level);
            player.setHeroHp(player.getHeroLvl()  + (10 * level));
            player.setHeroDef(5 * level);
            player.setHeroAtt(5 * level);
        }
    }

    public void addArtefact(Hero player) {
        int level = player.getHeroLvl();
        int artefactIndex = rand.nextInt(7) + 1;
        if (artefactIndex == 1){
            player.setHeroAtt(5 * level);
            JOptionPane.showMessageDialog(null, "You are the sword master!!!" );
        } else if (artefactIndex == 2){
            player.setHeroDef(5 * level);
            JOptionPane.showMessageDialog(null, "Behold the shield of truth!!!" );
        } else if (artefactIndex == 3){
            player.setHeroHp(5 * level);
            JOptionPane.showMessageDialog(null, "You have obtained the ring of vitality!!" );
        }
    }

    public void onMove(String direction, Map map, Hero hero) {
        int x = map.getPlayerX();
        int y = map.getPlayerY();
        map.setPreviousPlayerX(x);
        map.setPreviousPlayerY(y);

        if (direction.equalsIgnoreCase("North!")){
            if (x == 0) {
                newLevel(hero);
                //return;
            } else {
                map.setPlayerX(map.getPlayerX() - 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    String[] options = {"fight", "flight"};
                    int opt = JOptionPane.showOptionDialog(null, "Fight or Flight",
                            "Click a button",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (opt == 0)
                        fight(hero, enemy, "gui");
                    else if (opt == 1)
                        run(map, hero, enemy);
                }
                map.loadMap(hero);
            }
        } else if (direction.equalsIgnoreCase("South!")){
            if (x == map.getMapX() - 1){
                newLevel(hero);
                //return;
            } else {
                map.setPlayerX(map.getPlayerX() + 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    String[] options = {"fight", "flight"};
                    int opt = JOptionPane.showOptionDialog(null, "Fight or Flight",
                            "Click a button",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (opt == 0)
                        fight(hero, enemy, "gui");
                    else if (opt == 1)
                        run(map, hero, enemy);
                }
                map.loadMap(hero);
            }
        } else if (direction.equalsIgnoreCase("East!")){
            if (y == map.getMapY() - 1){
                newLevel(hero);
                //return;
            } else {
                map.setPlayerY(map.getPlayerY() + 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    String[] options = {"fight", "flight"};
                    int opt = JOptionPane.showOptionDialog(null, "Fight or Flight",
                            "Click a button",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (opt == 0)
                        fight(hero, enemy, "gui");
                    else if (opt == 1)
                        run(map, hero, enemy);
                }
                map.loadMap(hero);
            }
        } else if (direction.equalsIgnoreCase("West!")){
            if (y == 1){
                newLevel(hero);
                //return;
            } else {
                map.setPlayerY(map.getPlayerY() - 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    String[] options = {"fight", "flight"};
                    int opt = JOptionPane.showOptionDialog(null, "Fight or Flight",
                            "Click a button",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (opt == 0)
                        fight(hero, enemy, "gui");
                    else if (opt == 1)
                        run(map, hero, enemy);
                }
                map.loadMap(hero);
            }
        }
    }

    private void newLevel(Hero hero) {
        hero.setHeroLvl(hero.getHeroLvl() + 1);
        startGame(hero);
        //GameForm gameForm = new GameForm(1000, 1000);
        //gameForm.dispose();
        GameGuiController gameGuiController = new GameGuiController(1000, 1000, hero);
        gameGuiController.showGameWindow();
    }

    private void gameOver(Hero player) {
        JOptionPane.showMessageDialog(null,player.getHeroName() + " died!");
        DatabaseController.deleteHero(player);
        GameForm gameForm = new GameForm(1000, 1000);
        gameForm.setVisible(false);
        OptionsGuiController optionsGuiController = new OptionsGuiController();
        optionsGuiController.showOptionsWindow();
    }
}
