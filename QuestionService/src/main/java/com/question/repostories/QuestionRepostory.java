package com.question.repostories;

import com.question.entities.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepostory extends JpaRepository<Question, Long> {
    @Query("SELECT DISTINCT q FROM Question q LEFT JOIN FETCH q.options WHERE q.quizId = :quizId")
    List<Question> findByQuizIdWithOptions(Long quizId);//usually nothing is written here but as quizId is foreign key so we have to custom function
}
