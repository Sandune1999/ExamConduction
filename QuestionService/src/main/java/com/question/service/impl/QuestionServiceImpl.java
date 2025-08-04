package com.question.service.impl;

import com.question.entities.Question;
import com.question.repostories.OptionsRepository;
import com.question.repostories.QuestionRepostory;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepostory questionRepostory;
    private OptionsRepository optionsRepository;

    public QuestionServiceImpl(OptionsRepository optionsRepository, QuestionRepostory questionRepostory) {
        this.optionsRepository = optionsRepository;
        this.questionRepostory = questionRepostory;
    }

    @Override
    @Transactional
    public Question create(Question question) {
        if(question.getOptions() != null) {
            question.getOptions().forEach(option -> option.setQuestion(question));
        }
        return questionRepostory.save(question);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Question> get() {
        return questionRepostory.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Question getOne(Long id) {
        return questionRepostory.findById(id).orElseThrow(()-> new RuntimeException("Question not found !!"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepostory.findByQuizIdWithOptions(quizId);
    }
}
