package Controller;

import Model.Enemy;
import Model.Hero;
import Model.Map;

import javax.swing.*;
import java.util.Random;

public class GameActionController {

    Map map;
    Random rand = new Random();

    public Map startGame(Hero hero) {
        map = new Map(hero);
        return map;
    }

    public void fight(Hero player, Enemy monster, String viewType) {
        int turn = 0;
        while (player.getHeroHp() > 0 || monster.getEnemyHp() > 0) {
            if (turn == 0) {
                int damage = player.getHeroAtt() - monster.getEnemyDef();
                monster.setEnemyHp(monster.getEnemyHp() - damage);
                if (viewType.equalsIgnoreCase("gui"))
                    System.out.println(monster.getEnemyName() + " takes " + damage + " damage" );
                else if(viewType.equalsIgnoreCase("console"))
                    JOptionPane.showMessageDialog(null, monster.getEnemyName() + " takes " + damage + " damage!");
                turn = 1;
            } else if(turn == 1) {
                int damage = monster.getEnemyAtt() - player.getHeroDef();
                player.setHeroHp(player.getHeroHp() - damage);
                if (viewType.equalsIgnoreCase("gui"))
                    System.out.println(player.getHeroName() + " takes " + damage + " damage!" );
                else if(viewType.equalsIgnoreCase("console"))
                    JOptionPane.showMessageDialog(null, player.getHeroName() + " takes " + damage + " damage!" );
                turn = 0;
            }
        }

    }

    public void run(Map map) {

    }

    public void levelUp(Hero player) {

    }

    public void addArtefact(Hero player){

    }

    public void onMove(String direction, Map map, Hero hero) {
        int x = map.getPlayerX();
        int y = map.getPlayerY();
        map.setPreviousPlayerX(x);
        map.setPreviousPlayerY(y);
        System.out.println("Player X: " + map.getPlayerX() + " Player Y: " + map.getPlayerY());
        if (direction.equalsIgnoreCase("North!")){
            map.setPlayerX(map.getPlayerX() - 1);
        } else if (direction.equalsIgnoreCase("South!")){
            map.setPlayerX(map.getPlayerX() + 1);
        } else if (direction.equalsIgnoreCase("East!")){
            map.setPlayerY(map.getPlayerY() + 1);
        } else if (direction.equalsIgnoreCase("West!")){
            map.setPlayerY(map.getPlayerY() - 1);
        }
        System.out.println("Player X: " + map.getPlayerX() + " Player Y: " + map.getPlayerY());
        map.loadMap(hero);
    }
}
