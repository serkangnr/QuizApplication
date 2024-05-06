package com.serkanguner.serkangunermaraton5testuygulamasi.service;

import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.AnswerSaveDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.AnswerSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Answer;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import com.serkanguner.serkangunermaraton5testuygulamasi.mapper.AnswerMapper;
import com.serkanguner.serkangunermaraton5testuygulamasi.repository.AnswerRepository;
import com.serkanguner.serkangunermaraton5testuygulamasi.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AnswerService extends ServiceManager<Answer,Long> {
    private final AnswerRepository answerRepository;
    public AnswerService(AnswerRepository answerRepository) {
        super(answerRepository);
        this.answerRepository = answerRepository;
    }


    public String saveAnswer(AnswerSaveRequestDto answerSaveRequestDto){
        Question  question = Question.builder()
                .id(answerSaveRequestDto.questionid())
                .build();
        Answer answer = Answer.builder()
                .content(answerSaveRequestDto.content())
                .correct(answerSaveRequestDto.correct())
                .question(question)
                .build();
        answerRepository.save(answer);

        return "Kayit Basarili";
    }





    public void saveAnswerWithDto(AnswerSaveRequestDto answerSaveRequestDto){
        answerRepository.save(AnswerMapper.INSTANCE.answerSaveRequestDtoToAnswer(answerSaveRequestDto));

    }
}
