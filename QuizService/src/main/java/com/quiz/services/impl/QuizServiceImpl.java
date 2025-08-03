package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();


        return quizzes.stream().peek(quiz -> quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()))).collect(Collectors.toList());

        /*
        Better version:- because we are changing the state of a external data i.e.,
         quiz by adding question in it so If you must mutate, do it with .peek()
         or traditional loops. because map are traditionally made for stateless.
         and we could not find bug when parallel processes done using thread

        List<Quiz> enriched = quizzes.stream()
    .peek(q -> q.setQuestions(questionMap.get(q.getId())))
    .collect(Collectors.toList());

    or

    List<Quiz> quizzes = quizRepository.findAll();
quizzes.forEach(q -> q.setQuestions(questionClient.getQuestionOfQuiz(q.getId())));
return quizzes;
         */
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
