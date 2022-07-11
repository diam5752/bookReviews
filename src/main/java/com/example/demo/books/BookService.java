package com.example.demo.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private final RestTemplate restTemplate;
    private static final String url = "https://gutendex.com/books/";

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("getBooks")
    public List<Book> getBooks(String bookTitle) {
        Book book = restTemplate.getForObject(url + "?search=" + bookTitle, Book.class);
        return Arrays.asList(book);
    }

    @Cacheable("getBooksById")
    public Result[] getBookById(Long bookId) {
        Book book = restTemplate.getForObject(url + "?ids=" + bookId, Book.class);
        return book.getResults();
    }
}
