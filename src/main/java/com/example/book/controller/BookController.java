package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.dto.request.BookCreateRequest;
import com.example.book.dto.request.BookUpdateRequest;
import com.example.book.dto.response.ApiResponse;
import com.example.book.service.BookService;
import com.example.book.type.book.BookSuccessType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController implements BookApi {
    private final BookService bookService;

    @PostMapping
    public ApiResponse<Book> create(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        Book book = bookService.save(bookCreateRequest);
        return ApiResponse.success(BookSuccessType.POST_RESULT_SUCCESS, book);
    }

    @GetMapping("/{bookId}")
    public ApiResponse<Book> read(@PathVariable("bookId") Long bookId) {
        Book book = bookService.findById(bookId);
        return ApiResponse.success(BookSuccessType.GET_RESULT_SUCCESS, book);
    }

    @GetMapping
    public ApiResponse<List<Book>> readAll() {
        List<Book> books = bookService.getAll();
        return ApiResponse.success(BookSuccessType.GET_ALL_RESULT_SUCCESS, books);
    }

    @PatchMapping("/{bookId}")
    public ApiResponse<Book> update(
            @PathVariable("bookId") Long bookId,
            @Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        Book book = bookService.update(bookId, bookUpdateRequest);
        return ApiResponse.success(BookSuccessType.PATCH_RESULT_SUCCESS, book);
    }

    @DeleteMapping("/{bookId}")
    public ApiResponse<?> delete(Long bookId) {
        bookService.deleteById(bookId);
        return ApiResponse.success(BookSuccessType.DELETE_SUCCESS);
    }
}
