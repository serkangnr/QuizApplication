package com.serkanguner.serkangunermaraton5testuygulamasi.dto.response;

import java.util.List;

public record QuestionAndTrueAnswerResponseDto(String content,List<TrueAnswerResponseDto> answers ) {
}
