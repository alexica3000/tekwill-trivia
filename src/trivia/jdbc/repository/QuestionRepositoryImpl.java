package trivia.jdbc.repository;

import trivia.jdbc.domain.Answer;
import trivia.jdbc.domain.Question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String database = "trivia";
    private final String userName = "postgres";
    private final String password = "123456";

    @Override
    public List<Question> findQuestionsByLevel(int level) {
        List<Question> questions = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url + database, userName, password)) {
            //retrive question
            PreparedStatement ps = c.prepareStatement("SELECT * FROM QUESTION Q  WHERE Q.LEVEL = ?");
            ps.setInt(1, level);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                Question question = new Question(r.getLong("id"), r.getInt("score"),
                                                 r.getInt("level"), r.getString("text"));
                questions.add(question);
            }

            //retrieve answers
            for (Question q : questions) {
                ps = c.prepareStatement("SELECT * FROM ANSWER A  WHERE A.QUESTION_ID = ?");
                ps.setLong(1, q.getId());
                r = ps.executeQuery();
                while (r.next()) {
                    Answer answer = new Answer(r.getLong("id"), r.getString("text"),
                                               r.getBoolean("is_correct"), r.getString("letter"));
                    q.addAnswer(answer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public boolean save(Question question) {
        try (Connection c = DriverManager.getConnection(url + database, userName, password)) {
            //insert question
            PreparedStatement ps = c.prepareStatement("INSERT INTO QUESTION VALUES (?, ?, ?, ?)");
            Long questionId = nextVal();
            ps.setLong(1, questionId);
            ps.setInt(2, question.getLevel());
            ps.setInt(3, question.getScore());
            ps.setString(4, question.getText());
            ps.executeUpdate();

            //insert answers
            for (Answer a : question.getAnswers()) {
                ps = c.prepareStatement("INSERT INTO ANSWER VALUES (?, ?, ?, ?, ?)");
                ps.setLong(1, nextVal());
                ps.setBoolean(2, a.isCorrect());
                ps.setString(3, a.getLetter());
                ps.setString(4, a.getText());
                ps.setLong(5, questionId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Question question) {
        try (Connection c = DriverManager.getConnection(url + database, userName, password)) {
            //delete answers
            PreparedStatement ps = c.prepareStatement("DELETE FROM ANSWER WHERE QUESTION_ID = ?");
            ps.setLong(1, question.getId());
            ps.executeUpdate();

            //delete question
            ps = c.prepareStatement("DELETE FROM QUESTION WHERE ID = ?");
            ps.setLong(1, question.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url + database, userName, password)) {
            //retrieve question
            PreparedStatement ps = c.prepareStatement("SELECT * FROM QUESTION Q");
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                Question question = new Question(r.getLong("id"), r.getInt("score"),
                                                 r.getInt("level"), r.getString("text"));
                questions.add(question);
            }

            //retrieve answers
            for (Question q : questions) {
                ps = c.prepareStatement("SELECT * FROM ANSWER A  WHERE A.QUESTION_ID = ?");
                ps.setLong(1, q.getId());
                r = ps.executeQuery();
                while (r.next()) {
                    Answer answer = new Answer(r.getLong("id"), r.getString("text"),
                                               r.getBoolean("is_correct"), r.getString("letter"));
                    q.addAnswer(answer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    private Long nextVal() {
        long nextVal = 0;
        try (Connection c = DriverManager.getConnection(url + database, userName, password)) {
            PreparedStatement idStatement = c.prepareStatement("SELECT nextval('hibernate_sequence')");
            ResultSet nextValResultSet = idStatement.executeQuery();
            if (nextValResultSet.next())
                nextVal = nextValResultSet.getLong("nextval");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextVal;
    }
}
