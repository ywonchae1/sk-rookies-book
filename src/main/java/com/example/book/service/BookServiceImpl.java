package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.dto.request.BookCreateRequest;
import com.example.book.dto.request.BookUpdateRequest;
import com.example.book.exception.NotFoundException;
import com.example.book.repository.BookRepository;
import com.example.book.type.book.BookErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(BookCreateRequest bookCreateRequest) {
        Book book = Book.from(bookCreateRequest);
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BookErrorType.NOT_FOUND));
    }

    @Override
    public Book update(Long bookId, BookUpdateRequest bookUpdateRequest) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BookErrorType.NOT_FOUND));
        book = book.update(bookUpdateRequest);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public void deleteById(Long bookId) {
        findById(bookId);
        bookRepository.deleteById(bookId);
    }
}
