package com.tekwill.learning.triviav2;

import java.util.Random;
import java.util.Scanner;

import static com.tekwill.learning.triviav2.Questions.*;

public class TriviaGameV2 {

    private static String questionCorrectAnswer;
    private static int questionScore;

    private static boolean invokedH1;
    private static boolean invokedH2;
    private static boolean invokedH3;
    private static boolean usedH1;
    private static boolean usedH2;
    private static boolean usedH3;
    private static int currentScore;
    private static int questionNumber;
    private static boolean gameMenuRunning;
    private static boolean gameOver;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Do you want to be a the Ultimate Trivia Man \uD83E\uDD13? ---");
        do {
            gamePreConfiguration();
            System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("START")) {
                do {
                    System.out.println("    [\u2753] You have 3 help options ( ASK a Friend - [H1], ASK Auditory - [H2], 50/50 - [H3])");

                    displayQuestions();
                    System.out.print("answer > ");
                    String userAnswer = scanner.nextLine();

                    validateResponse(userAnswer);

                    if (questionNumber >= 5) {
                        System.out.println("     [\uD83E\uDD73] You won!");
                        System.out.println("     [\uD83E\uDD73] You got : " + currentScore);
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

    private static void displayQuestions() {
        switch (questionNumber) {
            case 1:
                displayQuestion(LEVEL_1_QUESTION_1,
                        LEVEL_1_QUESTION_1_ANSWER_1,
                        LEVEL_1_QUESTION_1_ANSWER_2,
                        LEVEL_1_QUESTION_1_ANSWER_3,
                        LEVEL_1_QUESTION_1_CORRECT_ANSWER_4,
                        LEVEL_1_QUESTION_1_SCORE);
                break;
            case 2:
                displayQuestion(
                        LEVEL_1_QUESTION_2,
                        LEVEL_1_QUESTION_2_ANSWER_1,
                        LEVEL_1_QUESTION_2_ANSWER_2,
                        LEVEL_1_QUESTION_2_ANSWER_3,
                        LEVEL_1_QUESTION_2_CORRECT_ANSWER_4,
                        LEVEL_1_QUESTION_2_SCORE);
                break;
            case 3:
                displayQuestion(
                        LEVEL_2_QUESTION_1,
                        LEVEL_2_QUESTION_1_ANSWER_1,
                        LEVEL_2_QUESTION_1_ANSWER_2,
                        LEVEL_2_QUESTION_1_ANSWER_3,
                        LEVEL_2_QUESTION_1_CORRECT_ANSWER_4,
                        LEVEL_2_QUESTION_1_SCORE);
                break;
            case 4:
                displayQuestion(
                        LEVEL_3_QUESTION_1,
                        LEVEL_3_QUESTION_1_ANSWER_1,
                        LEVEL_3_QUESTION_1_ANSWER_2,
                        LEVEL_3_QUESTION_1_ANSWER_3,
                        LEVEL_3_QUESTION_1_CORRECT_ANSWER_4,
                        LEVEL_3_QUESTION_1_SCORE);
                break;
        }
    }

    private static void validateResponse(String questionResponse) {
        if (questionResponse.equalsIgnoreCase(questionCorrectAnswer)) {
            questionNumber++;
            currentScore += questionScore;
            System.out.println("    [\uD83E\uDD29] Yaaay! Current score : " + currentScore);
        } else if (questionResponse.equalsIgnoreCase("H1") && !usedH1) {
            usedH1 = true;
            invokedH1 = true;
        } else if (questionResponse.equalsIgnoreCase("H2") && !usedH2) {
            usedH2 = true;
            invokedH2 = true;
        } else if (questionResponse.equalsIgnoreCase("H3") && !usedH3) {
            usedH3 = true;
            invokedH3 = true;
        } else if (questionResponse.equalsIgnoreCase("H1") || questionResponse.equalsIgnoreCase("H2") || questionResponse.equalsIgnoreCase("H3")) {
            System.out.println("     [\u2757] You`ve used all of your help options, now please respond.");
        } else {
            System.out.println("     [\uD83D\uDE22] Oopsie... Game Over!");
            gameOver = true;
        }
    }

    private static void gamePreConfiguration() {
        gameMenuRunning = true;
        gameOver = false;

        questionNumber = 1;
        questionScore = 0;
        questionCorrectAnswer = "";

        currentScore = 0;

        usedH1 = false;
        usedH2 = false;
        usedH3 = false;

        invokedH1 = false;
        invokedH2 = false;
        invokedH3 = false;
    }

    private static void displayQuestion(String question, String answerOne, String answerTwo, String answerThree, String correctAnswer, int score) {
        if (invokedH1) {
            System.out.println("    (\uD83D\uDDE3) -> Friend tells that most probably is this one - " + correctAnswer + " - 99.7%");
            invokedH1 = false;
        } else if (invokedH2) {
            System.out.println("    (\uD83D\uDC65) -> Auditory voted like this: ");
            int firstProbability = new Random().nextInt(24);
            int secondProbability = new Random().nextInt(24);
            int thirdProbability = new Random().nextInt(24);
            System.out.println("          \u2B55 " + answerOne + " - " + firstProbability + "%");
            System.out.println("          \u2B55 " + answerTwo + " - " + secondProbability + "%");
            System.out.println("          \u2B55 " + answerThree + " - " + thirdProbability + "%");
            System.out.println("          \u2B55 " + correctAnswer + " - " + (100 - firstProbability - secondProbability - thirdProbability) + "%");
            invokedH2 = false;
        } else if (invokedH3) {
            System.out.println("    (\uD83E\uDD16) -> Computer says: ");
            System.out.println("          \u2B55 " + answerThree + " - 50%");
            System.out.println("          \u2B55 " + correctAnswer + " - 50%");
            invokedH3 = false;
        } else {
            System.out.println("    [\uD83D\uDCCC] " + questionNumber + ". " + question);
            System.out.println("          \u2B55 " + answerOne);
            System.out.println("          \u2B55 " + answerTwo);
            System.out.println("          \u2B55 " + answerThree);
            System.out.println("          \u2B55 " + correctAnswer);
        }

        questionCorrectAnswer = correctAnswer;
        questionScore = score;
    }
}