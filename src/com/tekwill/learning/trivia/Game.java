package com.tekwill.learning.trivia;

import java.util.Scanner;

public class Game {
    static boolean gameMenu = true;
    static boolean gameOver = true;
    static int questionNumber = 1;
    static int questionScore = 0;
    static int totalScore = 0;
    static String questionCorrectAnswer = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter START to start the game or EXIT for exit.");
        String enter = scanner.nextLine();

        do {
            if(enter.equals("START")) {
                System.out.println("Start game...");
                do {
                    switch (questionNumber) {
                        case 1:
                            System.out.println(Questions.LEVEL_1_QUESTION_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_3);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_4);
                            questionCorrectAnswer = Questions.LEVEL_1_QUESTION_1_ANSWER_1;
                            questionScore = Questions.LEVEL_1_QUESTION_1_SCORE;
                            break;
                        case 2:
                            System.out.println(Questions.LEVEL_1_QUESTION_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_3);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_4);
                            questionCorrectAnswer = Questions.LEVEL_1_QUESTION_3_ANSWER_1;
                            questionScore = Questions.LEVEL_1_QUESTION_2_SCORE;
                            break;
                        case 3:
                            System.out.println(Questions.LEVEL_1_QUESTION_3);
                            System.out.println(Questions.LEVEL_1_QUESTION_3_ANSWER_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_3_ANSWER_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_3_ANSWER_3);
                            System.out.println(Questions.LEVEL_1_QUESTION_3_ANSWER_4);
                            questionCorrectAnswer = Questions.LEVEL_1_QUESTION_3_ANSWER_1;
                            questionScore = Questions.LEVEL_1_QUESTION_3_SCORE;
                            break;
                    }

                    String response = scanner.nextLine();

                    if (response.equalsIgnoreCase(questionCorrectAnswer)) {
                        questionNumber++;
                        totalScore += questionScore;
                        System.out.println("Correct. Score is: " + totalScore);
                    } else {
                        System.out.println("Incorrect. You have " + totalScore);
                        enter = "EXIT";
                        gameOver = false;
                    }

                } while (gameOver);

            } else if (enter.equals("EXIT")) {
                System.out.println("End game...");
                gameMenu = false;
            } else {
                System.out.println("Please enter START or EXIT.");
            }
        } while (gameMenu);
    }
}
