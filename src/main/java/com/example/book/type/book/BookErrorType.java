package com.example.book.type.book;

import com.example.book.type.ErrorType;

public enum BookErrorType implements ErrorType {
    CREATE_FAILED("BOOK_1", "도서 저장에 실패하였습니다"),
    NOT_FOUND("BOOK_2", "도서 정보를 찾을 수 없습니다");

    private final String code;
    private final String message;

    BookErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
