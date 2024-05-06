package com.serkanguner.serkangunermaraton5testuygulamasi.exception;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Bu sinif tum controller siniflari icin merkezi bir sekilde hata yonetimmi saglayacaktir.
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class) // RuntimeException Hata yakalayici bir metod oldugunu belirtmek icin.
    public ResponseEntity<String> handleException(){
        return ResponseEntity.badRequest().body("Uygulamada Runtime Exception Olustu...........");
    }


    @ExceptionHandler(QuizAppException.class)
    public ResponseEntity<ErrorMessage> handleDemoException(QuizAppException quizAppException){
        ErrorType errorType = quizAppException.getErrorType();

        return new ResponseEntity(createErrorMessage(quizAppException),errorType.getHttpStatus());
    }

    private ErrorMessage createErrorMessage(QuizAppException quizAppException) {
       return ErrorMessage.builder()
               .code(quizAppException.getErrorType().getCode())
               .message(quizAppException.getMessage())
               .build();
    }



}
