package com.question.controller;



import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question Question){
        return questionService.addQuestion(Question);
    }

    @GetMapping
    public List<Question> getAll(){
       return questionService.getAllQuestion();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id){
        return questionService.get(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);
    }
}
