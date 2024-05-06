package com.serkanguner.serkangunermaraton5testuygulamasi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    QUESTION_NOT_FOUND(5001,"Question not found. ", HttpStatus.NOT_FOUND),
    ANSWER_NOT_FOUND(5002,"Answer not found!",HttpStatus.NOT_FOUND);


    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}
