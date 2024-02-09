package com.quiz.service;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionClient questionClient;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("No Quiz found of id : "+ id));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
        return quiz;
    }
}
