package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //create
    //when we call post in "/quiz" through postman
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    //when we call get in "/quiz" through postman
    @GetMapping
    public List<Quiz> get() {
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id) {
        return quizService.get(id);
    }
}
