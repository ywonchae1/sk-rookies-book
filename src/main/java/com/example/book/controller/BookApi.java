package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.dto.request.BookCreateRequest;
import com.example.book.dto.request.BookUpdateRequest;
import com.example.book.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "도서(books)")
public interface BookApi {
    @Operation(summary = "도서 저장")
    ApiResponse<Book> create(@Valid @RequestBody BookCreateRequest bookCreateRequest);

    @Operation(summary = "도서 단일 조회")
    ApiResponse<Book> read(@PathVariable("bookId") Long bookId);

    @Operation(summary = "도서 전체 조회")
    ApiResponse<List<Book>> readAll();

    @Operation(summary = "도서 수정")
    ApiResponse<Book> update(
            @PathVariable("bookId") Long bookId,
            @Valid @RequestBody BookUpdateRequest bookUpdateRequest);

    @Operation(summary = "도서 삭제")
    ApiResponse<?> delete(@PathVariable("bookId") Long bookId);
}
