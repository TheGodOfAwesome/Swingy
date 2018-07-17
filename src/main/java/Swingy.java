package main.java;

import main.java.Controller.GameController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swingy {

    public static void main(String [] args){
        int screenWidth = 1080;
        int screenHeight = 1080;
        GameController gameController = new GameController(screenWidth, screenHeight);
        gameController.showGameWindow();

    }
}
