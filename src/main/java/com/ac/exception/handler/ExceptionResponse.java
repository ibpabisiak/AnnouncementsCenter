package com.ac.exception.handler;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {

    private Instant timestamp;
    private String message;
    private String errorCode;
}
