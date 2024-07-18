package com.example.book.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class BookCreateRequest {
    @NotNull(message = "도서 제목을 입력하세요")
    private String title;
    @NotNull(message = "도서 저자를 입력하세요")
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private String description;

    @Builder
    public BookCreateRequest(String title, String author, String publisher, LocalDate publishDate, String description) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
    }
}
