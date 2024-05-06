package com.serkanguner.serkangunermaraton5testuygulamasi.controller;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.AnswerSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.serkanguner.serkangunermaraton5testuygulamasi.constant.EndPoints.*;
@RestController
@RequestMapping(ROOT + ANSWER)
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PutMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> saveAnswer(AnswerSaveRequestDto answerSaveRequestDto){
        ResponseEntity<String> responseEntity = ResponseEntity.ok(answerService.saveAnswer(answerSaveRequestDto));
       return responseEntity;
    }
}
