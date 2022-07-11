package com.example.demo.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("/sortByRating")
    public List<Review> getReviewsOrderedByAvgRating(@RequestParam int numberOfBooks) {
        return reviewService.getBooksOrderByRating(numberOfBooks);
    }

    @PostMapping("/add")
    public void registerNewReview(@Valid @RequestBody Review review) {
        reviewService.addNewReview(review);
    }
}
