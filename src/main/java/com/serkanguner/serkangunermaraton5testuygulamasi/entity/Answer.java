package com.serkanguner.serkangunermaraton5testuygulamasi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
