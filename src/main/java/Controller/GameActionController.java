package Controller;

import Model.Hero;

public class GameActionController {

    /*public void onMove(String direction) {
        int x = game.getHeroCoord().getX();
        int y = game.getHeroCoord().getY();
        previousPosition.setX(x);
        previousPosition.setY(y);

        switch (direction.toLowerCase()) {
            case "n":
                y--;
                break;
            case "e":
                x++;
                break;
            case "w":
                x--;
                break;
            case "s":
                y++;
                break;
        }
    }*/

    public void startGame(Hero hero) {
        System.out.print(hero.getHeroName() + " arrived in a new hostile environment");
    }

    public void fight() {

    }

    public void run() {

    }

    public void levelUp() {

    }


}
