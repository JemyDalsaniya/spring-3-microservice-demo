package com.question.service;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question Question) {
        return questionRepository.save(Question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("No Question found of id : "+ id));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
