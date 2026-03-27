package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "9780547928227", 12.99));
            repository.save(new Book("1984", "George Orwell", 1949, "9780451524935", 10.50));
            repository.save(new Book("Pride and Prejudice", "Jane Austen", 1813, "9780141439518", 9.99));
        };
    }
}