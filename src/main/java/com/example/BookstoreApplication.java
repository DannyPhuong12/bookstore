package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return (args) -> {
            Category scifi = new Category("Sci-Fi");
            Category comic = new Category("Comic");
            Category fantasy = new Category("Fantasy");

            categoryRepository.save(scifi);
            categoryRepository.save(comic);
            categoryRepository.save(fantasy);

            bookRepository.save(new Book("Dune", "Frank Herbert", 1965, "9780441172719", 19.90, scifi));
            bookRepository.save(new Book("Watchmen", "Alan Moore", 1987, "9780930289232", 24.90, comic));
            bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "9780547928227", 14.90, fantasy));
        };
    }
}