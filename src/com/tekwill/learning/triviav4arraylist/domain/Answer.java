package com.tekwill.learning.triviav4arraylist.domain;

import java.util.Objects;

public class Answer {
    private String text;
    private boolean isCorrect;
    private String letter;

    public Answer(String text, boolean isCorrect, String letter) {
        this.text = text;
        this.isCorrect = isCorrect;
        this.letter = letter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return isCorrect == answer.isCorrect && Objects.equals(text, answer.text) && Objects.equals(letter, answer.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, isCorrect, letter);
    }

    @Override
    public String toString() {
        return letter + ". " + text;
    }
}
