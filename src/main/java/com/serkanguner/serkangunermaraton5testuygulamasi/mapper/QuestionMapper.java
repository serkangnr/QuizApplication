package com.serkanguner.serkangunermaraton5testuygulamasi.mapper;

import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.QuestionWithAnswerSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.QuestionsSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionAndTrueAnswerResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.QuestionWithAnswerFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    Question questionDtoToQuestion(QuestionsSaveRequestDto questionDto);
    QuestionFindAllResponseDto questionToQuestionFindAllResponseDto(Question question);
    QuestionWithAnswerFindAllResponseDto questionWithAnswerFindAllResponseDtoToQuestion(Question question);


    QuestionAndTrueAnswerResponseDto questionAndTrueAnswerResponseDtoToQuestion(Question question);
    @Mapping(target = "content", source = "questionWithAnswerSaveRequestDto.content")
    Question questionDtoToQuestionWithAnswerSaveRequestDto(QuestionWithAnswerSaveRequestDto questionWithAnswerSaveRequestDto);


}
