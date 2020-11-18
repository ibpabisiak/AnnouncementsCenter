package com.ac.exception.message;

import java.text.MessageFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    RESOURCE_NOT_FOUND("resource_not_found", "Resource with following ID doesn't exists in database: {0}"),
    BAD_CATEGORY_URL("bad_category_url", "Category with following URL doesn't exists: {0}");

    private final String errorCode;
    private final String message;

    public String formatWithId(String id) {
        return MessageFormat.format(getMessage(), id);
    }
}
