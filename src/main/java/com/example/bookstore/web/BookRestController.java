package com.example.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@RestController
@RequestMapping("/bookapi")
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }
}