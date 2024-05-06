package com.serkanguner.serkangunermaraton5testuygulamasi.dto.response;

import java.util.List;

public record QuestionWithAnswerFindAllResponseDto(String content, List<AnswerFindAllResponseDto> answers) {
}
