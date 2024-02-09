package com.quiz.service;


import com.quiz.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    Quiz get(Long id);

}
