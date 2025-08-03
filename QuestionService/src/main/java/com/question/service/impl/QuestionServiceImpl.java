package com.question.service.impl;

import com.question.entities.Question;
import com.question.repostories.QuestionRepostory;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepostory questionRepostory;

    public QuestionServiceImpl(QuestionRepostory questionRepostory) {
        this.questionRepostory = questionRepostory;
    }

    @Override
    public Question create(Question question) {
        return questionRepostory.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepostory.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepostory.findById(id).orElseThrow(()-> new RuntimeException("Question not found !!"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepostory.findByQuizId(quizId);
    }
}
