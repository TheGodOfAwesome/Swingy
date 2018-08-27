package View;

import Controller.DatabaseController;
import Controller.GameConsoleActionController;
import Controller.GameGuiController;
import Model.Hero;
import Model.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    //Map map;
    GameConsoleActionController consoleActionController  = new GameConsoleActionController();

    public void newMap(Hero hero) {
        //map = GameConsoleActionController.startGame(hero);
        Map map = new Map(hero);

        String help  =  "To traverse the environment type\n " +
                "'North'/'N' to go up\n " +
                "'South'/'S' to go down\n " +
                "'West'/'W' to go left\n " +
                "'East'/'E' to go right\n " +
                "'Save' to save you heroes progress\n " +
                "'Switch' to switch to GUI\n " +
                "'Exit'/'X' to quit game\n";

        System.out.println("You are in the centre of a Lair\n");
        System.out.println(help);
        System.out.println("Begin...\n");
        CaptureGameInputs(hero, map);
    }

    public void CaptureGameInputs(Hero hero, Map map){
        String help  =  "To traverse the environment type\n " +
                "'North'/'N' to go up\n " +
                "'South'/'S' to go down\n " +
                "'West'/'W' to go left\n " +
                "'East'/'E' to go right\n " +
                "'Save' to save you heroes progress\n " +
                "'Switch' to switch to GUI\n " +
                "'Exit'/'X' to quit game\n";
        boolean run = true;
        Scanner sc=new Scanner(System.in);
        while(run) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("x"))
                System.exit(1);
            else if(input.equalsIgnoreCase("north") || input.equalsIgnoreCase("n")) {
                System.out.println("Going up.\n");
                consoleActionController.onMove("North!", map, hero);
            }
            else if(input.equalsIgnoreCase("south") || input.equalsIgnoreCase("s")) {
                System.out.println("Going down.\n");
                consoleActionController.onMove("South!", map, hero);
            }
            else if(input.equalsIgnoreCase("west") || input.equalsIgnoreCase("w")) {
                System.out.println("Going left.\n");
                consoleActionController.onMove("West!", map, hero);
            }
            else if(input.equalsIgnoreCase("east") || input.equalsIgnoreCase("e")) {
                System.out.println("Going right.\n");
                consoleActionController.onMove("East!", map, hero);
            }
            else if(input.equalsIgnoreCase("Save")) {
                System.out.println("Saving Hero.\n");
                DatabaseController.updateHero(hero);
            }
            else if(input.equalsIgnoreCase("Switch")) {
                System.out.println("Switching to GUI.\n");
                GameGuiController gameGuiController = new GameGuiController(1000, 1000, hero);
                gameGuiController.showGameWindow();
            }
            else
                System.out.println(input + " is an invalid command\n" + help + "Continue...");
        }
        sc.close();
    }

    public void CaptureHeroOptions(){
        String help  =  "To create a hero type C\n" +
                        "To load a hero a hero type L\n" +
                        "'Exit'/'X' to quit game\n";

        System.out.println(help);
        boolean run = true;
        Scanner sc=new Scanner(System.in);
        while(run) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("x"))
                System.exit(1);
            else if(input.equalsIgnoreCase("C")) {
                System.out.println("Create a hero!\n");
                CreateHero();
            }
            else if(input.equalsIgnoreCase("L")) {
                System.out.println("Pick a Hero to Load!\n");
                LoadHero();
            }
            else
                System.out.println(input + " is an invalid command\n" + help + "Continue...");
        }
        sc.close();
    }

    public void CreateHero(){
        Hero hero = new Hero();
        String name = "";
        String help  =  "You can restart hero creation by typing R";
        System.out.println(help);

        String step1  =  "To enter Hero name type 'Name :'  and your preferred hero name e.g. 'Name : Goat'";
        System.out.println(step1);


        boolean run = true;
        Scanner sc=new Scanner(System.in);
        while(run) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("x"))
                System.exit(1);
            else if(input.toLowerCase().contains("name: ") || input.toLowerCase().contains("name:") || input.toLowerCase().contains("name : ")) {
                input = input.replaceAll("\\s+","");
                input = input.split(":")[1];
                System.out.println("Your hero name is "+ input +"\n");
                name = input;
                System.out.println("Type T to get and select hero type\n");
            } else if(input.equalsIgnoreCase("R")) {
                System.out.println("Resetting create hero!he\n");
                CreateHero();
            }
            else if(input.equalsIgnoreCase("T")) {
                if (name == "") {
                  System.out.println(step1);
                } else {
                    System.out.println("Samurai\n" +
                            "Samurai Stats\n " +
                            "   • 1         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 5        Defense\n" +
                            "   • 100       Hit Points\n");

                    System.out.println("Kunoichi\n" +
                            "Kunoichi Stats\n " +
                            "   • 1         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 2        Defense\n" +
                            "   • 100       Hit Points\n");

                    System.out.println("Archer\n" +
                            "Archer Stats\n " +
                            "   • 1         Level\n" +
                            "   • 0         Experience\n" +
                            "   • 10        Attack\n" +
                            "   • 8        Defense\n" +
                            "   • 100       Hit Points");

                    System.out.println("To select a hero type, enter the type name and watch out for spelling errors\n");
                }
            }
            else if(input.equalsIgnoreCase("Samurai")) {
                if (name == "") {
                    System.out.println(step1);
                } else {
                    String message = "Samurai";
                    hero.HeroName = name;
                    hero.HeroClass = "Samurai";
                    hero.HeroHp = 100;
                    hero.HeroAtt = 10;
                    hero.HeroDef = 5;
                    hero.HeroLvl = 1;
                    hero.HeroXp = 0;
                    System.out.println(message + " selected!");
                    DatabaseController.insertHero(hero);
                    newMap(hero);
                }
            }
            else if(input.equalsIgnoreCase("Kunoichi")) {
                if (name == "") {
                    System.out.println(step1);
                } else {
                    String message = "Kunoichi";
                    hero.HeroName = name;
                    hero.HeroClass = "Kunoichi";
                    hero.HeroHp = 100;
                    hero.HeroAtt = 10;
                    hero.HeroDef = 2;
                    hero.HeroLvl = 0;
                    hero.HeroXp = 0;
                    System.out.println(message + " selected!");
                    DatabaseController.insertHero(hero);
                    newMap(hero);
                }
            }
            else if(input.equalsIgnoreCase("Archer")) {
                if (name == "") {
                    System.out.println(step1);
                } else {
                    String message = "Archer";
                    hero.HeroName = name;
                    hero.HeroClass = "Archer";
                    hero.HeroHp = 100;
                    hero.HeroAtt = 10;
                    hero.HeroDef = 8;
                    hero.HeroLvl = 0;
                    hero.HeroXp = 0;
                    System.out.println(message + " selected!");
                    DatabaseController.insertHero(hero);
                    newMap(hero);
                }
            }
            else
                System.out.println(input + " is an invalid command\n" + help + " continue...");
        }
        sc.close();
    }

    public void LoadHero(){
        String help  =  "Pick your hero to continue from where you left off.\nSend the hero name to lock in your pick!\nMake sure the HeroName is spelt correctly!\n";
        System.out.println(help);

        Hero hero = new Hero();
        List<String> heroNames = new ArrayList<String>();

        List<Hero> heroes = DatabaseController.selectAll();
        for(int i = 0; i < heroes.size(); i++) {
            System.out.println(heroes.get(i).HeroName);
            System.out.println(heroes.get(i).HeroLvl);
            System.out.println(heroes.get(i).HeroHp);
            System.out.println(heroes.get(i).HeroDef);
            System.out.println(heroes.get(i).HeroAtt);
            System.out.println();

            heroNames.add(heroes.get(i).HeroName);
        }

        System.out.println(help);

        boolean run = true;
        Scanner sc=new Scanner(System.in);
        while(run) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("x"))
                System.exit(1);
            else if(heroNames.contains(input)) {
                hero = DatabaseController.selectHero(input);
                System.out.println("Loading " + hero.getHeroName() + "...\n");
                newMap(hero);
            }
            else
                System.out.println(input + " is an invalid hero name\n" + help + "Continue...");
        }
        sc.close();
    }
}
