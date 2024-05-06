package com.serkanguner.serkangunermaraton5testuygulamasi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorMessage {
    private Integer code;
    private String message;
}
