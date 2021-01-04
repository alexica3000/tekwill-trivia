package com.tekwill.learning.trivia;

import java.util.Scanner;

public class Game {
    static boolean gameMenu = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter START to start the game or EXIT for exit.");

        do {
            String enter = scanner.nextLine();

            if(enter.equals("START")) {
                System.out.println("Start game...");
            } else if (enter.equals("EXIT")) {
                System.out.println("End game...");
                gameMenu = false;
            } else {
                System.out.println("Please enter START or EXIT.");
            }
        } while (gameMenu);
    }
}
