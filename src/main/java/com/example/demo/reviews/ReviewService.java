package com.example.demo.reviews;

import com.example.demo.books.BookService;
import com.example.demo.books.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookService bookService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookService bookService) {
        this.reviewRepository = reviewRepository;
        this.bookService = bookService;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @CacheEvict(cacheNames = "getReviewsAndBookByBookId", allEntries = true)
    public void addNewReview(Review review) {

        Optional<Review> reviewById = reviewRepository
                .findReviewsById(review.getId());
        Result[] bookExists = bookService.getBookById(review.getBookId());

        if (bookExists.length == 0) {
            throw new IllegalStateException("Book Id does not exist");
        }

        if (reviewById.isPresent()) {
            throw new IllegalStateException("Review Id already exists");
        }

        reviewRepository.save(review);
    }

    public List<Review> getBooksOrderByRating(int numberOfBooks) {
        return reviewRepository.getBooksOrderByRating(PageRequest.of(0, numberOfBooks));
    }
}
