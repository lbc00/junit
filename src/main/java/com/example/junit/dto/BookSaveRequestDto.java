package com.example.junit.dto;

import com.example.junit.domain.Book;
import lombok.Data;

@Data
public class BookSaveRequestDto {
    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }
}
