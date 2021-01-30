package com.tekwill.learning.triviav3array.repository;

import com.tekwill.learning.triviav3array.domain.Answer;
import com.tekwill.learning.triviav3array.domain.Question;

public class QuestionRepository {
    public Question[] questions = new Question[]{
            new Question(100, 1, "How many wings does a mosquito have?",
                    new Answer[]{
                            new Answer("Two", true, "A"), new Answer("Three", false, "B"),
                            new Answer("Four", false, "C"), new Answer("Ten", false, "D")}),

            new Question(100, 1, "Ascorbic acid is a form of which vitamin?",
                    new Answer[]{
                            new Answer("A", false, "A"), new Answer("B", false, "B"),
                            new Answer("C", false, "C"), new Answer("D", true, "D")}),

            new Question(250, 2, "Humans and chimpanzees share roughly how much DNA?",
                    new Answer[]{
                            new Answer("98%", false, "A"), new Answer("77%", false, "B"),
                            new Answer("100%", true, "C"), new Answer("0%", false, "D")}),

            new Question(250, 2, "'Felis domesticus' is Latin for which animal?",
                    new Answer[]{
                            new Answer("Dog", false, "A"), new Answer("Cat", false, "B"),
                            new Answer("Mouse", true, "C"), new Answer("Chicken", false, "D")}),

            new Question(350, 3, "Where is the heart of the shrimp situated?",
                    new Answer[]{
                            new Answer("In the head", false, "A"), new Answer("In the shoulder", true, "B"),
                            new Answer("In the foot", false, "C"), new Answer("In the solpa", false, "D")}),

            new Question(350, 3, "Where is the heart of the bimbo located?",
                    new Answer[]{
                            new Answer("In the bead", false, "A"), new Answer("In the boulder", true, "B"),
                            new Answer("In the boot", false, "C"), new Answer("In the dolpa", false, "D")}),
    };


    public Question[] findQuestionsByLevel(int level) {
        int resultSize = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getLevel() == level)
                resultSize++;
        }
        Question[] result = new Question[resultSize];
        for (int i = 0, j = 0; i < questions.length; i++) {
            if (questions[i].getLevel() == level)
                result[j++] = questions[i];
        }
        return result;
    }
}
