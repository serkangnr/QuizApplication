package com.serkanguner.serkangunermaraton5testuygulamasi.repository;

import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
