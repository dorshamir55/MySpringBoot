package com.example.MySpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ValueOutOfRangeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String MESSAGE="Value out of range.";

    public ValueOutOfRangeException() {
        super(MESSAGE);
    }

    public ValueOutOfRangeException(Throwable throwable) {
        super(MESSAGE, throwable);
    }
}
