package com.question.service;

import com.question.entity.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question Question);
    List<Question> getAllQuestion();
    Question get(Long id);
    List<Question> getQuestionOfQuiz(Long quizId);

}
