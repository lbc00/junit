package com.example.junit.domain;

import com.example.junit.dto.BookSaveRequestDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @BeforeEach
    public void 데이터준비() {
        String title = "junit5";
        String author = "메타코딩";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        // when
        Book bookPS = bookRepository.save(book);
    }

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

    @Test
    void 책목록보기_test() {
        // when
        List<Book> books = bookRepository.findAll();
        // then
        assertEquals(books.size(), 1);
    }

    @Test
    public void 책한건보기_test() {
        // given
        String title = "junit5";
        String author = "메타코딩";
        // when
        Book bookPS = bookRepository.findById(1L).get();
        // then
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }
}
