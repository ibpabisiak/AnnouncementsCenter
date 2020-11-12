package com.ac.exception.message;

import java.text.MessageFormat;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    RESOURCE_NOT_FOUND("resource_not_found", "Resource with following id doesn't exists in database: {0}");

    private final String errorCode;
    private final String message;

    public String formatWithId(UUID id) {
        return MessageFormat.format(getMessage(), id);
    }
}
