package com.tekwill.learning.triviav3array.domain;

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
    public String toString() {
        return letter + ". " + text;
    }
}
