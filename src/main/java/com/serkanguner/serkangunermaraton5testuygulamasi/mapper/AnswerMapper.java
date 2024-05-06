package com.serkanguner.serkangunermaraton5testuygulamasi.mapper;

import com.serkanguner.serkangunermaraton5testuygulamasi.dto.request.AnswerSaveRequestDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.dto.response.AnswerFindAllResponseDto;
import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    //@Mapping(target = "questionid",source = "answerDto.question.id")
    Answer answerSaveRequestDtoToAnswer(AnswerSaveRequestDto answerDto);

    AnswerFindAllResponseDto answerToAnswerFindAllResponseDto(Answer answer);

}
