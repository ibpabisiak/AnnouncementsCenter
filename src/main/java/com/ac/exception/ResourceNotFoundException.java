package com.ac.exception;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message);
    }
}
