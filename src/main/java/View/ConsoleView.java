package View;

import java.util.Scanner;

public class ConsoleView {

    public void CaptureGameInputs(){
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
                System.exit(1);
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
    }

    public void CaptureCreateHeroInputs(){
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
                System.exit(1);
            else if(input.equalsIgnoreCase("north") || input.equalsIgnoreCase("n"))
                System.out.println("Going up.\n");
            else if(input.equalsIgnoreCase("south") || input.equalsIgnoreCase("s"))
                System.out.println("Going down.\n");
            else if(input.equalsIgnoreCase("east") || input.equalsIgnoreCase("e"))
                System.out.println("Going right.\n");
            else
                System.out.println(input + " is an invalid command\n" + help + "Continue...");
        }
        sc.close();
    }
}
