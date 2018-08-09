
import Controller.*;
import Model.Hero;
import View.ConsoleView;

import java.util.Scanner;

public class Swingy {

    public static void main(String [] args){
        if (args.length == 1) {
            DbConnController.connect();
            DatabaseController.createNewTable();
            Hero hero = new Hero();
            hero.HeroName = "Kuzi";
            hero.HeroClass = "Knight";
            hero.HeroHp = 100;
            hero.HeroAtt = 10;
            hero.HeroDef = 20;
            hero.HeroHp = 30;
            hero.HeroLvl = 40;
            hero.HeroXp = 50;
            DatabaseController.InsertHeroRecord(hero);
            Hero newHero = DatabaseController.GetHeroFromTable("Kuzi");
            System.out.println(newHero.HeroName + "\n" + newHero.HeroClass + "\n" + newHero.HeroHp
                    + "\n" + newHero.HeroAtt + "\n" + newHero.HeroDef + "\n" + newHero.HeroLvl + "\n" + newHero.HeroXp + "\n");
            System.out.println("Game Started!");
            System.out.println(args[0] + "\n");
            if (args[0].equalsIgnoreCase("Gui")){
                OptionsGuiController optionsGuiController = new OptionsGuiController();
                optionsGuiController.showOptionsWindow();
            } else if (args[0].equalsIgnoreCase("Console")) {
                System.out.println("Welcome to Lair's & Lizards\n");
                String help  =  "Menu\n " +
                        "'Play'/'P' to play or continue from where you left off.\n " +
                        "'Hero'/'H' to create a hero or load a previous one.\n " +
                        "'Switch'/'S' to switch to the Graphic Game Interface\n " +
                        "'Exit'/'X' to quit game\n";
                System.out.println(help);
                boolean run = true;
                Scanner sc=new Scanner(System.in);
                ConsoleView consoleView = new ConsoleView();
                while(run) {
                    String input = sc.nextLine();
                    if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("x"))
                        break;
                    else if(input.equalsIgnoreCase("play") || input.equalsIgnoreCase("p"))
                        consoleView.CaptureGameInputs();
                    else if(input.equalsIgnoreCase("hero") || input.equalsIgnoreCase("h"))
                        consoleView.CaptureCreateHeroInputs();
                    else if(input.equalsIgnoreCase("switch") || input.equalsIgnoreCase("s"))
                        System.out.println("Feature Coming Soon!!!.\n");
                    else
                        System.out.println(input + " is an invalid command\n" + help + "Continue...");
                }
                sc.close();
                return;
            } else {
                System.out.println("Incorrect interface argument!\n");
            }
        } else {
            System.out.println("Please select just interface argument! E.g. Console or Gui\n");
            return;
        }
    }
}
