package com.example.labemt2.service;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Book;
import com.example.labemt2.model.Category;

import java.util.List;

public interface BookServiceInterface{
    List<Book> listAll();

    Book create(String name, Category category, List<Author> author, Integer availableCopies);

    Book delete(Long id);

    Book findById(Long id);

    Book update(Long id,String name, Category category, List<Author> author, Integer availableCopies);

    Book markAsTaken(Long id);
}
