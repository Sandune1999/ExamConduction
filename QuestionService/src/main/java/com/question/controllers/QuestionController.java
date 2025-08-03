package com.question.controllers;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create
    @PostMapping
    public Question create(@RequestBody Question question) {
//        @RequestBody QuestionDTO dto
//        Question question = new Question();
//        question.setQuizId(dto.getQuizId());
//        question.setQuestion(dto.getText());
//
//        List<Options.java>  options = new ArrayList<>();
//        for(OptionsDTO optionsDTO : dto.getOptions()) {
//            Options.java option = new Options.java();
//            option.setText(optionsDTO.getText());
//            option.setCorrect(optionsDTO.isCorrect());
//            option.setQuestion(question);
//
//            options.add(option);
//        }
//
//        question.setOptions(options);

        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.get();
    }

    @GetMapping("/{questionId}")
    public Question getOne(@PathVariable Long questionId) {
        return questionService.getOne(questionId);
    }

    //get all question of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
