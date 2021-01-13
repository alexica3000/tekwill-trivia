package com.tekwill.learning.triviav2;

import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        boolean gameMenuRunning = true;
        boolean gameOver = false;
        int questionNumber = 1;
        int questionScore = 0;
        int currentScore = 0;
        String currentCorrectAnswer = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to be a the Ultimate Trivia Man?");
        do {
            System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("START")) {
                do {
                    switch (questionNumber) {
                        case 1:
                            System.out.println(Questions.LEVEL_1_QUESTION_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_ANSWER_3);
                            System.out.println(Questions.LEVEL_1_QUESTION_1_CORRECT_ANSWER_4);
                            currentCorrectAnswer = Questions.LEVEL_1_QUESTION_1_CORRECT_ANSWER_4;
                            questionScore = Questions.LEVEL_1_QUESTION_1_SCORE;
                            break;
                        case 2:
                            System.out.println(Questions.LEVEL_1_QUESTION_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_1);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_2);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_ANSWER_3);
                            System.out.println(Questions.LEVEL_1_QUESTION_2_CORRECT_ANSWER_4);
                            currentCorrectAnswer = Questions.LEVEL_1_QUESTION_2_CORRECT_ANSWER_4;
                            questionScore = Questions.LEVEL_1_QUESTION_2_SCORE;
                            break;
                        case 3:
                            System.out.println(Questions.LEVEL_2_QUESTION_1);
                            System.out.println(Questions.LEVEL_2_QUESTION_1_ANSWER_1);
                            System.out.println(Questions.LEVEL_2_QUESTION_1_ANSWER_2);
                            System.out.println(Questions.LEVEL_2_QUESTION_1_ANSWER_3);
                            System.out.println(Questions.LEVEL_2_QUESTION_1_CORRECT_ANSWER_4);
                            currentCorrectAnswer = Questions.LEVEL_2_QUESTION_1_CORRECT_ANSWER_4;
                            questionScore = Questions.LEVEL_2_QUESTION_1_SCORE;
                            break;
                        case 4:
                            System.out.println(Questions.LEVEL_3_QUESTION_1);
                            System.out.println(Questions.LEVEL_3_QUESTION_1_ANSWER_1);
                            System.out.println(Questions.LEVEL_3_QUESTION_1_ANSWER_2);
                            System.out.println(Questions.LEVEL_3_QUESTION_1_ANSWER_3);
                            System.out.println(Questions.LEVEL_3_QUESTION_1_CORRECT_ANSWER_4);
                            currentCorrectAnswer = Questions.LEVEL_3_QUESTION_1_CORRECT_ANSWER_4;
                            questionScore = Questions.LEVEL_3_QUESTION_1_SCORE;
                            break;
                    }

                    String questionResponse = scanner.nextLine();

                    if (questionResponse.equalsIgnoreCase(currentCorrectAnswer)) {
                        questionNumber++;
                        currentScore += questionScore;
                        System.out.println("Yaaay! Current score : " + currentScore);
                    } else {
                        System.out.println("Oopsie... Game Over!");
                        gameOver = true;
                    }

                    if (questionNumber >= 5) {
                        System.out.println("You won!");
                        System.out.println("You got : " + currentScore);
                        gameOver = true;
                    }

                } while (!gameOver);
            } else if (response.equalsIgnoreCase("EXIT")) {
                System.out.println("Bye, bye!");
                gameMenuRunning = false;
            } else {
                System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            }

        } while (gameMenuRunning);
    }
}
