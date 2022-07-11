package com.example.demo.bookreviewAPI;

import com.example.demo.books.BookService;
import com.example.demo.books.Result;
import com.example.demo.reviews.ReviewRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookReviewService {
    private final BookService bookService;
    private final ReviewRepository reviewRepository;

    public BookReviewService(BookService bookService, ReviewRepository reviewRepository) {
        this.bookService = bookService;
        this.reviewRepository = reviewRepository;
    }

    @Cacheable("getReviewsAndBookByBookId")
    public BookReview getReviewsAndBookByBookId(Long bookId) {

        Result[] booksResults = bookService.getBookById(bookId);
        String[] reviewsList = reviewRepository.findReviewsByBookId(bookId);

        BookReview bookReview = new BookReview();
        bookReview.setId(booksResults[0].getId());
        bookReview.setAuthors(booksResults[0].getAuthors());
        bookReview.setLanguages(booksResults[0].getLanguages());
        bookReview.setDownload_count(booksResults[0].getDownload_count());
        bookReview.setRating(reviewRepository.findAvgRatingByBookId(bookId));
        bookReview.setReviews(reviewsList);

        return bookReview;
    }
}
