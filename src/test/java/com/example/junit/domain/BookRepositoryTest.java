package com.example.junit.domain;

import com.example.junit.dto.BookSaveRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    public void 책등록_test() {
        // given
        String title = "junit5";
        String author = "메타코딩";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        // when
        Book bookPS = bookRepository.save(book);

        // then
        assertThat(title).isEqualTo(bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }
}
