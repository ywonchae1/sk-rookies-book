package com.example.book.domain;

import com.example.book.dto.request.BookCreateRequest;
import com.example.book.dto.request.BookUpdateRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Book {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Book(
            Long id,
            String title,
            String author,
            String publisher,
            LocalDate publishDate,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Book from(BookCreateRequest bookCreateRequest) {
        return Book.builder()
                .title(bookCreateRequest.getTitle())
                .author(bookCreateRequest.getAuthor())
                .publisher(bookCreateRequest.getPublisher())
                .publishDate(bookCreateRequest.getPublishDate())
                .description(bookCreateRequest.getDescription())
                .build();
    }

    public Book update(BookUpdateRequest bookUpdateRequest) {
        this.title = bookUpdateRequest.getTitle() != null ? bookUpdateRequest.getTitle() : this.title;
        this.author = bookUpdateRequest.getAuthor() != null ? bookUpdateRequest.getAuthor() : this.author;
        this.publisher = bookUpdateRequest.getPublisher() != null ? bookUpdateRequest.getPublisher() : this.publisher;
        this.publishDate = bookUpdateRequest.getPublishDate() != null ? bookUpdateRequest.getPublishDate() : this.publishDate;
        this.description = bookUpdateRequest.getDescription() != null ? bookUpdateRequest.getDescription() : this.description;
        return this;
    }
}
