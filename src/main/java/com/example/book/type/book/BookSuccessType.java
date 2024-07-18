package com.example.book.type.book;

import com.example.book.type.SuccessType;

public enum BookSuccessType implements SuccessType {
    POST_RESULT_SUCCESS("BOOK_1", "도서 저장에 성공하였습니다"),
    GET_RESULT_SUCCESS("BOOK_2", "도서 단일 조회에 성공하였습니다"),
    GET_ALL_RESULT_SUCCESS("BOOK_3", "도서 전체 조회에 성공하였습니다"),
    PATCH_RESULT_SUCCESS("BOOK_4", "도서 수정에 성공하였습니다"),
    DELETE_SUCCESS("BOOK_5", "도서 삭제에 성공하였습니다");

    private final String code;
    private final String message;

    BookSuccessType(String code, String message) {
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
