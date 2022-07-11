package com.example.demo.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReviewConfig {
    @Bean
    CommandLineRunner commandLineRunner(ReviewRepository repository) {
        return args -> {
            Review reviewA = new Review(
                    1,
                    2,
                    "Review A"
            );

            Review reviewB = new Review(
                    1,
                    4,
                    "Review B"
            );

            Review reviewC = new Review(
                    2,
                    5,
                    "Review C"
            );

            Review reviewD = new Review(
                    2,
                    5,
                    "Review D"
            );

            repository.saveAll(
                    List.of(reviewA, reviewB, reviewC, reviewD)
            );
        };
    }
}
