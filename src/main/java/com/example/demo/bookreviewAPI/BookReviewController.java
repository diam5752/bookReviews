package com.example.demo.bookreviewAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/bookReviews/")
public class BookReviewController {

    private final BookReviewService bookReviewService;

    @Autowired
    public BookReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    @GetMapping("/{bookId}")
    public BookReview getReviewsAndBookByBookId(@PathVariable Long bookId) {
        return bookReviewService.getReviewsAndBookByBookId(bookId);
    }
}
