package com.serkanguner.serkangunermaraton5testuygulamasi.repository;

import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Optional<Question> findById(Long id);
    List<Question> findQuestionByContentContainingIgnoreCase(String content);




}
