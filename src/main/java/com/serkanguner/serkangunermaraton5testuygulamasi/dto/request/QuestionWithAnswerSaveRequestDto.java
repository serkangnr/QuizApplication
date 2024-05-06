package com.serkanguner.serkangunermaraton5testuygulamasi.dto.request;

import java.util.List;

public record QuestionWithAnswerSaveRequestDto(String content, List<AnswerSaveDto> answers ) {
}
