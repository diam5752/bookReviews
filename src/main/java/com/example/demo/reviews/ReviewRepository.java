package com.example.demo.reviews;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository
        extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.id = ?1")
    Optional<Review> findReviewsById(Long Id);

    @Query("SELECT AVG(rating) FROM Review WHERE bookId = ?1")
    Float findAvgRatingByBookId(Long Id);

    @Query("SELECT r.review FROM Review r WHERE r.bookId =  ?1")
    String[] findReviewsByBookId(Long bookId);

    @Query("SELECT new com.example.demo.reviews.Review ( r.bookId , AVG( r.rating) )  FROM Review r GROUP BY r.bookId ORDER BY AVG( r.rating) DESC ")
    List<Review> getBooksOrderByRating(Pageable pageable);
}
