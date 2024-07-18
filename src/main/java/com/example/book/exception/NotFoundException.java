package com.example.book.exception;

import com.example.book.type.ErrorType;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(ErrorType errorType) {
        super(errorType, HttpStatus.NOT_FOUND);
    }
}
