package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.dto.request.BookCreateRequest;
import com.example.book.dto.request.BookUpdateRequest;

import java.util.List;

public interface BookService {
    Book save(BookCreateRequest bookCreateRequest);

    Book findById(Long bookId);

    Book update(Long bookId, BookUpdateRequest bookUpdateRequest);

    List<Book> getAll();

    void deleteById(Long bookId);
}
