package com.serkanguner.serkangunermaraton5testuygulamasi.dto.request;

import com.serkanguner.serkangunermaraton5testuygulamasi.entity.Question;
import org.springframework.stereotype.Component;


public record AnswerSaveDto(String content, Boolean correct) {
}
