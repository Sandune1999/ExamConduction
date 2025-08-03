package com.question.repostories;

import com.question.entities.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepostory extends JpaRepository<Question, Long> {

    List<Question> findByQuizId(Long quizId);//usually nothing is written here but as quizId is foreign key so we have to custom function

//    @EntityGraph(value = "Question.options", type = EntityGraph.EntityGraphType.FETCH)
//    @Query("SELECT q FROM Question q")
//    @Override List<Question> findAll();
}
