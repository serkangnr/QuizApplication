package com.serkanguner.serkangunermaraton5testuygulamasi.controller;

import static com.serkanguner.serkangunermaraton5testuygulamasi.constant.EndPoints.*;

import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.QuestionsSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionAndTrueAnswerResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionWithAnswerFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import com.serkanguner.serkangunermaraton5testuygulamasi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ROOT + QUESTION)
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody QuestionsSaveRequestDto questionsSaveRequestDto){
       questionService.saveQuestionWithDto(questionsSaveRequestDto);
        return ResponseEntity.ok("Question saved");
    }


//    @PostMapping(SAVEQUESTIONANDANSWER)
//    @CrossOrigin("*")
//    public ResponseEntity<String> saveQuestionAndAnswer(@RequestBody QuestionWithAnswerSaveRequestDto questionWithAnswerSaveRequestDto){
//        questionService.saveQuestionWithAnswers(questionWithAnswerSaveRequestDto);
//        return ResponseEntity.ok("Question and answer saved");
//    }

    @GetMapping(FINDALLONLYQUESTION)
    @CrossOrigin("*")
    public ResponseEntity<List<QuestionFindAllResponseDto>> getOnlyQuestion(){
        return ResponseEntity.ok(questionService.getOnlyQuestions());
    }

    @GetMapping(FINDQUESTIONANDANSWER)
    @CrossOrigin("*")
    public ResponseEntity<List<QuestionWithAnswerFindAllResponseDto>> getQuestionAndAnswer(){
        return ResponseEntity.ok(questionService.getQuestionsWithAnswers());
    }

    @GetMapping(FINDQUESTIONRESULT)
    @CrossOrigin("*")
    public ResponseEntity<List<QuestionAndTrueAnswerResponseDto>> getResult(){
        return ResponseEntity.ok(questionService.getQuestionAndAnswerWithIsCorrect());
    }












}
