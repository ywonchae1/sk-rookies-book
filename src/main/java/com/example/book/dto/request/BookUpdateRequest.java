package com.example.book.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookUpdateRequest {
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private String description;

    @Builder
    public BookUpdateRequest(String title, String author, String publisher, LocalDate publishDate, String description) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
    }
}
