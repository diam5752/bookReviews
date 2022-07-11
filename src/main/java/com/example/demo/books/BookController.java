package com.example.demo.books;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam String bookTitle) {
        return bookService.getBooks(bookTitle);
    }

    @GetMapping("/{bookId}")
    public Result[] getBooksById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }
}
