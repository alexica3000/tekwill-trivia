package trivia.jdbc.domain;


import trivia.jdbc.domain.exceptions.EmptyQuestionTextException;
import trivia.jdbc.domain.exceptions.InvalidLevelException;
import trivia.jdbc.domain.exceptions.InvalidScoreException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Question {
    private Long id;
    private List<Answer> answers = new ArrayList<>();
    private int score;
    private int level;
    private String text;

    /*
     * connect to db
     * write query
     * select * from question; List<Question>
     * for Question q : questions
     *   select * from answer where question_id = q.id; List<Answer>
     *   q.addAll(answer)
     *
     * List<Question> -> List<Answer>
     * */

    public Question(Long id, List<Answer> answers, int score, int level, String text) {
        this(score, level, text, answers);
        this.id = id;
    }

    public Question(Long id, int score, int level, String text) {
        this(score, level, text);
        this.id = id;
    }

    public Question(int score, int level, String text, List<Answer> answers) {
        this(score, level, text);
        this.answers = answers;
        this.answers.forEach(a -> a.setQuestion(this));
    }

    public Question(Long id, int score, int level, String text, List<Answer> answers) {
        this(score, level, text);
        this.id = id;
        this.answers = answers;
        this.answers.forEach(a -> a.setQuestion(this));
    }


    public Question(int score, int level, String text) {
        if (text.isEmpty()) {
            throw new EmptyQuestionTextException("Question text should not be empty");
        }
        if (score < 0) {
            throw new InvalidScoreException("Score must be greater than 0");
        }
        if (level < 0) {
            throw new InvalidLevelException("Level must be greater than 0");
        }
        this.score = score;
        this.level = level;
        this.text = text;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer getCorrectAnswer() {
        for (Answer answer : answers) {
            if (answer.isCorrect())
                return answer;
        }
        return null;
    }

    public List<Answer> getWrongAnswers() {
        List<Answer> wrongAnswers = new ArrayList<>();
        for (Answer answer : answers) {
            if (!answer.isCorrect()) {
                wrongAnswers.add(answer);
            }
        }
        Collections.shuffle(wrongAnswers);
        return wrongAnswers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return score == question.score && level == question.level && Objects.equals(id,
                                                                                    question.id) && Objects.equals(
                answers, question.answers) && Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answers, score, level, text);
    }

    @Override
    public String toString() {
        return "Question{" +
                "answers=" + answers +
                ", score=" + score +
                ", level=" + level +
                ", text='" + text + '\'' +
                '}';
    }
}
