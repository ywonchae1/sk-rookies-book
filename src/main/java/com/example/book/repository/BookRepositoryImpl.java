package com.example.book.repository;

import com.example.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final BookJpaRepository bookJpaRepository;

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = bookJpaRepository.save(BookEntity.from(book));
        System.out.println(bookEntity.getCreatedAt());
        return bookEntity.toModel();
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookJpaRepository.findById(bookId).map(BookEntity::toModel);
    }

    @Override
    public List<Book> getAll() {
        return bookJpaRepository.findAll().stream().map(BookEntity::toModel).toList();
    }

    @Override
    public void deleteById(Long bookId) {
        bookJpaRepository.deleteById(bookId);
    }
}
