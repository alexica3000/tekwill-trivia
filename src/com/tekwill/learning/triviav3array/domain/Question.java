package com.tekwill.learning.triviav3array.domain;

import java.util.Arrays;

import static com.tekwill.learning.triviav3array.util.Shuffler.shuffleAnswers;

public class Question {
    private final Answer[] answers;
    private int score;
    private int level;
    private String text;

    public Question(int score, int level, String text, Answer[] answers) {
        this.score = score;
        this.level = level;
        this.text = text;
        this.answers = answers;
        //validate just one correct answer
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public Answer getCorrectAnswer() {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].isCorrect())
                return answers[i];
        }
        return null;
    }

    public Answer[] getWrongAnswers() {
        Answer[] wrongAnswers = new Answer[answers.length - 1];
        for (int i = 0, k = 0; i < answers.length; i++) {
            if (!answers[i].isCorrect()) {
                wrongAnswers[k++] = answers[i];
            }
        }
        return shuffleAnswers(wrongAnswers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "score=" + score +
                ", level=" + level +
                ", text='" + text + '\'' +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}
