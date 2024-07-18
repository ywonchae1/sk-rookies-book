package com.example.book.repository;

import com.example.book.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> findById(Long bookId);

    List<Book> getAll();

    void deleteById(Long bookId);
}
