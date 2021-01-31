package com.tekwill.learning.triviav4arraylist.repository;

import com.tekwill.learning.triviav4arraylist.domain.Answer;
import com.tekwill.learning.triviav4arraylist.domain.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionRepository {
    public List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question(100, 1, "How many wings does a mosquito have?",
                    Arrays.asList(new Answer("Two", true, "A"), new Answer("Three", false, "B"),
                            new Answer("Four", false, "C"), new Answer("Ten", false, "D"))),

            new Question(100, 1, "Ascorbic acid is a form of which vitamin?",
                    Arrays.asList(new Answer("A", false, "A"), new Answer("B", false, "B"),
                            new Answer("C", false, "C"), new Answer("D", true, "D"))),

            new Question(250, 2, "Humans and chimpanzees share roughly how much DNA?",
                    Arrays.asList(new Answer("98%", false, "A"), new Answer("77%", false, "B"),
                            new Answer("100%", true, "C"), new Answer("0%", false, "D"))),

            new Question(250, 2, "'Felis domesticus' is Latin for which animal?",
                    Arrays.asList(new Answer("Dog", false, "A"), new Answer("Cat", false, "B"),
                            new Answer("Mouse", true, "C"), new Answer("Chicken", false, "D"))),

            new Question(350, 3, "Where is the heart of the shrimp situated?",
                    Arrays.asList(new Answer("In the head", false, "A"), new Answer("In the shoulder", true, "B"),
                            new Answer("In the foot", false, "C"), new Answer("In the solpa", false, "D"))),

            new Question(350, 3, "Where is the heart of the bimbo located?",
                    Arrays.asList(new Answer("In the bead", false, "A"), new Answer("In the boulder", true, "B"),
                            new Answer("In the boot", false, "C"), new Answer("In the dolpa", false, "D")))));


    public List<Question> findQuestionsByLevel(int level) {
        List<Question> result = new ArrayList<>();
        for (int i = 0, j = 0; i < questions.size(); i++) {
            if (questions.get(i).getLevel() == level)
                result.add(questions.get(i));
        }
        return result;
    }
}
