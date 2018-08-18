
import Controller.*;
import Model.Hero;
import View.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class Swingy {

    public static void main(String [] args){
        if (args.length == 1) {
            DatabaseController.createNewDatabase();
            DatabaseController.createHeroTable();
            //DatabaseController.insertHero(hero);
            //DatabaseController.deleteHero(hero);
            List<Hero> heroes = DatabaseController.selectAll();
            //DatabaseController.updateHero(hero);
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
