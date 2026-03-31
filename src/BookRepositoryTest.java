package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void createBook() {
        Book book = new Book("Test", "Author", 2020, "123", 10.0, null);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Book book = new Book("Delete", "Author", 2020, "123", 10.0, null);
        repository.save(book);

        repository.delete(book);

        assertThat(repository.findById(book.getId())).isEmpty();
    }
}