import Controller.GuiGameController;

import java.util.Scanner;

public class Swingy {

    public static void main(String [] args){
        int screenWidth = 1080;
        int screenHeight = 1080;
        if (args.length == 1) {
            System.out.println("Game Started!");
            System.out.println(args[0] + "\n");
            if (args[0].equalsIgnoreCase("Gui")){
                GuiGameController guiGameController = new GuiGameController(screenWidth, screenHeight);
                guiGameController.showGameWindow();
            } else if (args[0].equalsIgnoreCase("Console")) {
                System.out.println("Welcome to Lair's & Lizards\n");
                String help  =  "To traverse the environment type\n " +
                                "'North'/'N' to go up\n " +
                                "'South'/'S' to go down\n " +
                                "'West'/'W' to go left\n " +
                                "'East'/'E' to go right\n " +
                                "'Exit'/'X' to quit game\n";

                System.out.println("You are in the centre of a Lair\n");
                System.out.println(help);
                System.out.println("Begin...\n");
                boolean run = true;
                Scanner sc=new Scanner(System.in);
                while(run) {
                    String input = sc.nextLine();
                    if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("x"))
                        break;
                    else if(input.equalsIgnoreCase("north") || input.equalsIgnoreCase("n"))
                        System.out.println("Going up.\n");
                    else if(input.equalsIgnoreCase("south") || input.equalsIgnoreCase("s"))
                        System.out.println("Going down.\n");
                    else if(input.equalsIgnoreCase("west") || input.equalsIgnoreCase("w"))
                        System.out.println("Going left.\n");
                    else if(input.equalsIgnoreCase("east") || input.equalsIgnoreCase("e"))
                        System.out.println("Going right.\n");
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
