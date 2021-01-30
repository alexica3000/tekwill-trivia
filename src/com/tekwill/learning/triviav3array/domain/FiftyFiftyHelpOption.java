package com.tekwill.learning.triviav3array.domain;

import java.util.Random;

public class FiftyFiftyHelpOption {
    private boolean isUsed = false;
    private boolean isInvoked = false;

    public void invoke(Question question) {
        Answer[] wrongAnswers = question.getWrongAnswers();
        Answer wrongAnswer = wrongAnswers[new Random().nextInt(wrongAnswers.length)];

        System.out.println("    (\uD83E\uDD16) -> Computer says: ");
        System.out.println("          \u2B55 " + wrongAnswer + " - 50%");
        System.out.println("          \u2B55 " + question.getCorrectAnswer() + " - 50%");

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
