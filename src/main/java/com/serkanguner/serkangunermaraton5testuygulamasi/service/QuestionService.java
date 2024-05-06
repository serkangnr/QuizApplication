package com.serkanguner.serkangunermaraton5testuygulamasi.service;

import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.QuestionsSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionAndTrueAnswerResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionWithAnswerFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import com.serkanguner.serkangunermaraton5testuygulamasi.exception.ErrorType;
import com.serkanguner.serkangunermaraton5testuygulamasi.exception.QuizAppException;
import com.serkanguner.serkangunermaraton5testuygulamasi.mapper.QuestionMapper;
import com.serkanguner.serkangunermaraton5testuygulamasi.repository.QuestionRepository;
import com.serkanguner.serkangunermaraton5testuygulamasi.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class QuestionService extends ServiceManager<Question, Long> {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;

    }

    //Save Just Question with DTO
    public void saveQuestionWithDto(QuestionsSaveRequestDto questionsSaveRequestDto) {
        questionRepository.save(QuestionMapper.INSTANCE.questionDtoToQuestion(questionsSaveRequestDto));
    }


    // Only brings Questions
    public List<QuestionFindAllResponseDto> getOnlyQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionFindAllResponseDto> questionFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
            questionFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionToQuestionFindAllResponseDto(question));
        }
        return questionFindAllResponseDtos;
    }

    // Bring Questions with Answers
    public List<QuestionWithAnswerFindAllResponseDto> getQuestionsWithAnswers() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionWithAnswerFindAllResponseDto> questionWithAnswerFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
            questionWithAnswerFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionWithAnswerFindAllResponseDtoToQuestion(question));
        }
        return questionWithAnswerFindAllResponseDtos;
    }

    // Bring Questions with Answers and Correct
    public List<QuestionAndTrueAnswerResponseDto> getQuestionAndAnswerWithIsCorrect() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionAndTrueAnswerResponseDto> questionWithAnswerFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
            questionWithAnswerFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionAndTrueAnswerResponseDtoToQuestion(question));
        }
        boolean empty = questionWithAnswerFindAllResponseDtos.isEmpty();
        if (empty) {
            throw new QuizAppException(ErrorType.QUESTION_NOT_FOUND);
        }
        return questionWithAnswerFindAllResponseDtos;
    }

    //

    /**
     * @param id : Enter id
     *           Bring Questions with Answers and Correct
     */
    public QuestionAndTrueAnswerResponseDto findUserDtoID(Long id) {
        Optional<Question> byId = questionRepository.findById(id);
        AtomicBoolean equals = new AtomicBoolean(false);
        findById(id).stream().forEach(question -> {
            equals.set(question.getId().equals(id));
        });
        if (equals.get()) {
            QuestionAndTrueAnswerResponseDto question = QuestionMapper.INSTANCE.questionAndTrueAnswerResponseDtoToQuestion(byId.get());
            return question;
        } else {
            throw new QuizAppException(ErrorType.QUESTION_NOT_FOUND);
        }
    }

    //Find Questions By Containing
    public List<QuestionWithAnswerFindAllResponseDto> findQuestionsByContentContaining(String content){
        List<Question> questions = questionRepository.findQuestionByContentContainingIgnoreCase(content);
//        List<Question> questions = questionRepository.findAll();
        List<QuestionWithAnswerFindAllResponseDto> questionWithAnswerFindAllResponseDtos = new ArrayList<>();
        for (Question question : questions) {
//            if(question.getContent().contains(content)){
                questionWithAnswerFindAllResponseDtos.add(QuestionMapper.INSTANCE.questionWithAnswerFindAllResponseDtoToQuestion(question));
            //}
        }
        boolean empty = questionWithAnswerFindAllResponseDtos.isEmpty();
        if (empty) {
            throw new QuizAppException(ErrorType.QUESTION_NOT_FOUND);
        }
        return questionWithAnswerFindAllResponseDtos;

    }
}



















