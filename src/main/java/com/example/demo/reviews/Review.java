package com.example.demo.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    @JsonIgnore
    private long id;
    private long bookId;
    @NotNull
    @Range(min = 0, max = 5)
    private double rating;
    @NotNull
    @Size(min = 2, message = "Review Text is empty.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String review;

    public Review() {
    }

    public Review(long bookId, double rating, String review) {
        this.bookId = bookId;
        this.rating = rating;
        this.review = review;
    }

    public Review(long bookId, double rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public Review(double rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public Review(long id, long bookId, double rating, String review) {
        this.id = id;
        this.rating = rating;
        this.review = review;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
