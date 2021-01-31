package com.tekwill.learning.triviav4arraylist.service;

import com.tekwill.learning.triviav4arraylist.domain.Question;
import com.tekwill.learning.triviav4arraylist.repository.QuestionRepository;

import java.util.Collections;
import java.util.List;

public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestionsByLevel(int level) {
        List<Question> questionsByLevel = questionRepository.findQuestionsByLevel(level);
        Collections.shuffle(questionsByLevel);
        return questionsByLevel;
    }
}
