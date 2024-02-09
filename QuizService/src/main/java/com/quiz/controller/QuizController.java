package com.quiz.controller;


import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAll(){
       return quizService.getAllQuiz();
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.get(id);
    }
}
