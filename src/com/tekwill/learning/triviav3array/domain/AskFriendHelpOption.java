package com.tekwill.learning.triviav3array.domain;

public class AskFriendHelpOption {
    private boolean isUsed = false;
    private boolean isInvoked = false;

    public void invoke(Question question) {
        System.out.println("    (\uD83D\uDDE3) -> Friend tells that most probably is this one - " + question.getCorrectAnswer() + " - 99.7%");
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
