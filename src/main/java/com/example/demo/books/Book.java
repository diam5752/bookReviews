package com.example.demo.books;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private Result[] results;
    @Transient
    private Long count;

    public Book() {
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Books{" +
                "results=" + Arrays.toString(results) +
                ", count=" + count +
                '}';
    }
}
