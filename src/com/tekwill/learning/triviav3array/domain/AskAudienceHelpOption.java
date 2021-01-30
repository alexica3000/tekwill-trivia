package com.tekwill.learning.triviav3array.domain;

import java.util.Random;

public class AskAudienceHelpOption {
    private boolean isUsed = false;
    private boolean isInvoked = false;

    public void invoke(Question question) {
        System.out.println("    (\uD83D\uDC65) -> Auditory voted like this: ");
        Answer[] wrongAnswers = question.getWrongAnswers();
        int wrongAnswerProbabilityLimit = 100 / wrongAnswers.length - 10;
        int correctAnswerProbabilityLimit = 100 - wrongAnswerProbabilityLimit * wrongAnswers.length;

        for (int i = 0; i < wrongAnswers.length; i++) {
            System.out.println("          \u2B55 " + wrongAnswers[i] + " - " + new Random().nextInt(wrongAnswerProbabilityLimit) + "%");
        }
        System.out.println("          \u2B55 " + question.getCorrectAnswer() + " - " + correctAnswerProbabilityLimit + "%");

        setUsed(true);
        setInvoked(false);
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isInvoked() {
        return isInvoked;
    }

    public void setInvoked(boolean invoked) {
        isInvoked = invoked;
    }
}
