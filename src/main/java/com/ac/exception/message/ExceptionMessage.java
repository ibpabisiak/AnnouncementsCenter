package com.ac.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    RESOURCE_NOT_FOUND("resource_not_found", "Announcement with following id doesn't exists in database: {0}");

    private final String errorCode;
    private final String message;
}
