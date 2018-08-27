package Controller;

import Model.Enemy;
import Model.Hero;
import Model.Map;
import View.ConsoleView;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class GameConsoleActionController {

   //Map map;

    public void fight(Hero player, Enemy monster, Map map, String viewType) {
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
                    levelUp(player, map);
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
                    System.out.println(player.getHeroName() + "Game Over!");
                    ConsoleView consoleView = new ConsoleView();
                    consoleView.CaptureHeroOptions();
                }
                turn = 0;
            }
        }
    }

    public void run(Map map, Hero hero, Enemy enemy) {
        Random rand = new Random();
        System.out.println("Your 'hero' is trying to run!!!" );
        boolean run =  rand.nextBoolean();
        if (run == true){
            fight(hero, enemy, map,map.getGameState());
        } else {
            System.out.println("Your 'hero' is running!!!" );
            map.setPlayerX(map.getPreviousPlayerX());
            map.setPlayerY(map.getPreviousPlayerY());
            ConsoleView consoleView = new ConsoleView();
            consoleView.CaptureGameInputs(hero, map);
        }
    }

    public void levelUp(Hero player, Map map) {
        int currentlevel = player.getHeroLvl();
        int level = currentlevel + 1;
        int xp = player.getHeroXp();
        int xpToNxtLevel = (level * 1000) + (level - (1 * 2450));
        if (xp == xpToNxtLevel) {
            System.out.println("Player leveling up!");
            player.setHeroLvl(level);
            player.setHeroHp(player.getHeroLvl()  + (10 * level));
            player.setHeroDef(5 * level);
            player.setHeroAtt(5 * level);
            ConsoleView consoleView = new ConsoleView();
            consoleView.newMap(player);
        }
        ConsoleView consoleView = new ConsoleView();
        consoleView.CaptureGameInputs(player, map);
    }

    public void addArtefact(Hero player) {
        Random rand = new Random();
        int level = player.getHeroLvl();
        int artefactIndex = rand.nextInt(7) + 1;
        if (artefactIndex == 1){
            player.setHeroAtt(5 * level);
            System.out.println("You are the sword master!!!" );
        } else if (artefactIndex == 2){
            player.setHeroDef(5 * level);
            System.out.println("Behold the shield of truth!!!" );
        } else if (artefactIndex == 3){
            player.setHeroHp(5 * level);
            System.out.println("You have obtained the ring of vitality!!" );
        }
    }

    public void onMove(String direction, Map map, Hero hero) {
        int x = map.getPlayerX();
        int y = map.getPlayerY();
        map.setPreviousPlayerX(x);
        map.setPreviousPlayerY(y);
        if (direction.equalsIgnoreCase("North!")){
            if (x == 0) {
                System.out.println("You entering a new Lair!");
                newLevel(hero);
                //return;
            } else {
                map.setPlayerX(map.getPlayerX() - 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    System.out.println("You have encounter a monster to choose where to fight or run,\nenter fight to fight and flight to try and run!");
                    boolean run = true;
                    Scanner sc = new Scanner(System.in);
                    while (run) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("fight"))
                            fight(hero, enemy, map,"console");
                        else if (input.equalsIgnoreCase("flight")) {
                            run(map, hero, enemy);
                        }
                    }
                }
                map.printMap();
                map.reloadMap(hero);
                //ConsoleView consoleView = new ConsoleView();
                //consoleView.CaptureGameInputs(hero, map);
            }
        } else if (direction.equalsIgnoreCase("South!")) {
            if (x == map.getMapX() - 1) {
                System.out.println("You entering a new Lair!");
                newLevel(hero);
                //return;
            } else {
                map.setPlayerX(map.getPlayerX() + 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    System.out.println("You have encounter a monster to choose where to fight or run,\nenter fight to fight and flight to try and run!");
                    boolean run = true;
                    Scanner sc = new Scanner(System.in);
                    while (run) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("fight"))
                            fight(hero, enemy, map,"console");
                        else if (input.equalsIgnoreCase("flight")) {
                            run(map, hero, enemy);
                        }
                    }
                }
                map.printMap();
                map.reloadMap(hero);
                //ConsoleView consoleView = new ConsoleView();
                //consoleView.CaptureGameInputs(hero, map);
            }
        } else if (direction.equalsIgnoreCase("East!")){
            if (y == map.getMapY() - 1){
                System.out.println("You entering a new Lair!");
                newLevel(hero);
                //return;
            } else {
                map.setPlayerY(map.getPlayerY() + 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    System.out.println("You have encounter a monster to choose where to fight or run,\nenter fight to fight and flight to try and run!");
                    boolean run = true;
                    Scanner sc = new Scanner(System.in);
                    while (run) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("fight"))
                            fight(hero, enemy, map,"console");
                        else if (input.equalsIgnoreCase("flight")) {
                            run(map, hero, enemy);
                        }
                    }
                }
                map.printMap();
                map.reloadMap(hero);
                //ConsoleView consoleView = new ConsoleView();
                //consoleView.CaptureGameInputs(hero, map);
            }
        } else if (direction.equalsIgnoreCase("West!")){
            if (y == 1){
                System.out.println("You entering a new Lair!");
                newLevel(hero);
                //return;
            } else {
                map.setPlayerY(map.getPlayerY() - 1);
                Enemy enemy = map.checkForEnemies();
                if (enemy != null) {
                    System.out.println("You have encounter a monster to choose where to fight or run,\nenter fight to fight and flight to try and run!");
                    boolean run = true;
                    Scanner sc = new Scanner(System.in);
                    while (run) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("fight"))
                            fight(hero, enemy, map,"console");
                        else if (input.equalsIgnoreCase("flight")) {
                            run(map, hero, enemy);
                        }
                    }
                }
                map.printMap();
                map.reloadMap(hero);
                //ConsoleView consoleView = new ConsoleView();
                //consoleView.CaptureGameInputs(hero, map);
            }
        }
    }


    private void newLevel(Hero hero) {
        hero.setHeroLvl(hero.getHeroLvl() + 1);
        ConsoleView consoleView = new ConsoleView();
        consoleView.newMap(hero);
    }
}
