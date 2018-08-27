package Controller;

import Model.Enemy;
import Model.Hero;
import Model.Map;

import javax.swing.*;
import java.util.Random;

public class GameConsoleActionController {

    Map map;
    Random rand = new Random();

    public Map startGame(Hero hero) {
        map = new Map(hero);
        return map;
    }

    public void fight(Hero player, Enemy monster, String viewType) {
        System.out.println("Fight fight fight!!!" );
        int turn = 0;
        while (player.getHeroHp() > 0 && monster.getEnemyHp() > 0) {
            if (turn == 0) {
                int damage = player.getHeroAtt() - monster.getEnemyDef();
                if (damage <= 0)
                    damage = 1;
                monster.setEnemyHp(monster.getEnemyHp() - damage);
                if (viewType.equalsIgnoreCase("console"))
                    System.out.println(monster.getEnemyName() + " takes " + damage + " damage" );
                else if(viewType.equalsIgnoreCase("gui"))
                    JOptionPane.showMessageDialog(null, monster.getEnemyName() + " takes " + damage + " damage!");
                if(monster.getEnemyHp() == 0) {
                    System.out.println(monster.getEnemyName() + " died!" );
                    map.removeEnemy(monster);
                    addArtefact(player);
                    levelUp(player);
                }
                turn = 1;
            } else if(turn == 1) {
                int damage = monster.getEnemyAtt() - player.getHeroDef();
                if (damage <= 0)
                    damage = 1;
                player.setHeroHp(player.getHeroHp() - damage);
                if (viewType.equalsIgnoreCase("console"))
                    System.out.println(player.getHeroName() + " takes " + damage + " damage!" );
                else if(viewType.equalsIgnoreCase("gui"))
                    JOptionPane.showMessageDialog(null, player.getHeroName() + " takes " + damage + " damage!" );
                if(player.getHeroHp() == 0) {
                    System.out.println(player.getHeroName() + " died!");
                    DatabaseController.deleteHero(player);
                }
                turn = 0;
            }
        }
    }

    public void run(Map map, Hero hero, Enemy enemy) {
        System.out.println("Your 'hero' is running!!!" );
        boolean run =  rand.nextBoolean();
        if (run == true){
            fight(hero, enemy, map.getGameState());
        } else {
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
        System.out.println("Player X: " + map.getPlayerX() + " Player Y: " + map.getPlayerY());
        if (direction.equalsIgnoreCase("North!")){
            map.setPlayerX(map.getPlayerX() - 1);
            Enemy enemy = map.checkForEnemies();
            if (enemy != null) {
                String[] options = {"fight", "flight"};
                int opt = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                        "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(opt);
                if (opt == 0)
                    fight(hero, enemy, "gui");
                else if (opt == 1)
                    run(map, hero, enemy);
            }
        } else if (direction.equalsIgnoreCase("South!")){
            map.setPlayerX(map.getPlayerX() + 1);
            Enemy enemy = map.checkForEnemies();
            if (enemy != null) {
                String[] options = {"fight", "flight"};
                int opt = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                        "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(opt);
                if (opt == 0)
                    fight(hero, enemy, "gui");
                else if (opt == 1)
                    run(map, hero, enemy);
            }
        } else if (direction.equalsIgnoreCase("East!")){
            map.setPlayerY(map.getPlayerY() + 1);
            Enemy enemy = map.checkForEnemies();
            if (enemy != null) {
                String[] options = {"fight", "flight"};
                int opt = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                        "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(opt);
                if (opt == 0)
                    fight(hero, enemy, "gui");
                else if (opt == 1)
                    run(map, hero, enemy);
            }
        } else if (direction.equalsIgnoreCase("West!")){
            map.setPlayerY(map.getPlayerY() - 1);
            Enemy enemy = map.checkForEnemies();
            if (enemy != null) {
                String[] options = {"fight", "flight"};
                int opt = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                        "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(opt);
                if (opt == 0)
                    fight(hero, enemy, "gui");
                else if (opt == 1)
                    run(map, hero, enemy);
            }
        }
        System.out.println("Player X: " + map.getPlayerX() + " Player Y: " + map.getPlayerY());
        map.loadMap(hero);
    }
}
