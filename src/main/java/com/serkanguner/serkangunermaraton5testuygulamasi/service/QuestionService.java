package com.serkanguner.serkangunermaraton5testuygulamasi.service;

import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.AnswerSaveDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.AnswerSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.QuestionWithAnswerSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.QuestionsSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionAndTrueAnswerResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionWithAnswerFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Answer;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import com.serkanguner.serkangunermaraton5testuygulamasi.mapper.AnswerMapper;
import com.serkanguner.serkangunermaraton5testuygulamasi.mapper.QuestionMapper;
import com.serkanguner.serkangunermaraton5testuygulamasi.repository.QuestionRepository;
import com.serkanguner.serkangunermaraton5testuygulamasi.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class QuestionService extends ServiceManager<Question, Long> {
    private final QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;

    }

    //Save Just Question with DTO
    public void saveQuestionWithDto(QuestionsSaveRequestDto questionsSaveRequestDto){
        questionRepository.save(QuestionMapper.INSTANCE.questionDtoToQuestion(questionsSaveRequestDto));
    }
    //    Save Question with Answer with DTO
//    public void saveQuestionWithAnswers(QuestionWithAnswerSaveRequestDto questionWithAnswersDto) {
//
//        Question question = new Question();
//        question.setContent(questionWithAnswersDto.content());
//
//
//        List<Answer> answers = new ArrayList<>();
//        for (AnswerSaveDto answerDto : questionWithAnswersDto.answers()) {
//            Answer answer = new Answer();
//            answer.setContent(answerDto.content());
//            answer.setIsCorrect(answerDto.isCorrect());
//            answer.setQuestion(question);
//            answers.add(answer);
//        }
//
//        question.setAnswers(answers);
//        questionRepository.save(question);
//    }

    public List<QuestionFindAllResponseDto> getOnlyQuestions(){
        List<Question> questions = questionRepository.findAll();
        List<QuestionFindAllResponseDto> questionFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
            questionFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionToQuestionFindAllResponseDto(question));
        }
        return questionFindAllResponseDtos;
    }
    public List<QuestionWithAnswerFindAllResponseDto> getQuestionsWithAnswers(){
        List<Question> questions = questionRepository.findAll();
        List<QuestionWithAnswerFindAllResponseDto> questionWithAnswerFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
            questionWithAnswerFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionWithAnswerFindAllResponseDtoToQuestion(question));
        }
        return questionWithAnswerFindAllResponseDtos;
    }

    public List<QuestionAndTrueAnswerResponseDto> getQuestionAndAnswerWithIsCorrect(){
        List<Question> questions = questionRepository.findAll();
        List<QuestionAndTrueAnswerResponseDto> questionWithAnswerFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
                questionWithAnswerFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionAndTrueAnswerResponseDtoToQuestion(question));
        }
        return questionWithAnswerFindAllResponseDtos;
    }


















}
