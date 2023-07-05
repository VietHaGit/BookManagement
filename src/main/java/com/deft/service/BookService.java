package com.deft.service;

import com.deft.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();
    Optional<Book> getById(Long id);
    Book update(Long id, Book book);
    void deleteById(Long id);
    Book create(Book book);
    List<Book> searchBooks(String name, Integer price, Integer priceMin, Integer priceMax, String author) throws Exception;
    Page<Book> searchBooks1(String name, Integer price, Integer priceMin, Integer priceMax, String author, int pageNumber, String sortBy) throws Exception;


}
