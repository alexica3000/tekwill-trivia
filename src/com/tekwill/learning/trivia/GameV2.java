package com.tekwill.learning.trivia;

import java.util.Scanner;

public class GameV2 {
    static boolean gameMenu = true;
    static boolean gameOver = true;
    static int totalQuestions = 3;
    static int questionNumber = 1;
    static int questionScore = 0;
    static int totalScore = 0;
    static int correctAnswers = 0;
    static String questionCorrectAnswer = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter START to start the game or EXIT for exit.");
        String enter = scanner.nextLine();

        do {
            if(enter.equalsIgnoreCase("START")) {
                System.out.println("Start game...");
                do {
                    System.out.println("-----------------------------------------------------");
                    displayQuestions();
                    String response = scanner.nextLine();
                    validateAnswer(response);

                    if (totalQuestions == questionNumber) {
                        System.out.println(correctAnswers + " answers from " + totalQuestions + " are correct.");
                        gameOver = false;
                        gameMenu = false;
                    }

                    questionNumber++;

                } while (gameOver);

            } else if (enter.equalsIgnoreCase("EXIT")) {
                System.out.println("End game...");
                gameMenu = false;
            } else {
                System.out.println("Please enter START or EXIT.");
            }
        } while (gameMenu);
    }

    private static void displayQuestions() {
        switch (questionNumber) {
            case 1:
                System.out.println(questionNumber + ". " + Questions.LEVEL_1_QUESTION_1);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_1_ANSWER_1);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_1_ANSWER_2);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_1_ANSWER_3);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_1_ANSWER_4);
                questionCorrectAnswer = Questions.LEVEL_1_QUESTION_1_ANSWER_1;
                questionScore = Questions.LEVEL_1_QUESTION_1_SCORE;
                break;
            case 2:
                System.out.println(questionNumber + ". " + Questions.LEVEL_1_QUESTION_2);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_2_ANSWER_1);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_2_ANSWER_2);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_2_ANSWER_3);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_2_ANSWER_4);
                questionCorrectAnswer = Questions.LEVEL_1_QUESTION_2_ANSWER_3;
                questionScore = Questions.LEVEL_1_QUESTION_2_SCORE;
                break;
            case 3:
                System.out.println(questionNumber + ". " + Questions.LEVEL_1_QUESTION_3);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_3_ANSWER_1);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_3_ANSWER_2);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_3_ANSWER_3);
                System.out.println("\t" + Questions.LEVEL_1_QUESTION_3_ANSWER_4);
                questionCorrectAnswer = Questions.LEVEL_1_QUESTION_3_ANSWER_1;
                questionScore = Questions.LEVEL_1_QUESTION_3_SCORE;
                break;
        }
    }

    private static void validateAnswer(String response) {
        if (response.equalsIgnoreCase(questionCorrectAnswer)) {
            correctAnswers++;
            totalScore += questionScore;
            System.out.println("Correct. Score is: " + totalScore);
        } else {
            System.out.println("Incorrect. You have " + totalScore);
        }
    }
}
