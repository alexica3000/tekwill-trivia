package com.tekwill.learning.triviav3array.service;

import com.tekwill.learning.triviav3array.domain.Question;
import com.tekwill.learning.triviav3array.repository.QuestionRepository;
import com.tekwill.learning.triviav3array.util.Shuffler;

public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question[] getQuestionsByLevel(int level) {
        return Shuffler.shuffleQuestions(questionRepository.findQuestionsByLevel(level));
    }

}
