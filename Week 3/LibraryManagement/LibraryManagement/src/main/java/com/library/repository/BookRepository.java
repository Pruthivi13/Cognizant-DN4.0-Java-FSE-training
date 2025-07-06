package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void fetchBook() {
        System.out.println("Fetching book from BookRepository...");
    }
}
