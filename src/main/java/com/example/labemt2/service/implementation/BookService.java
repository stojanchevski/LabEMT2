package com.example.labemt2.service.implementation;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Book;
import com.example.labemt2.model.Category;
import com.example.labemt2.repository.BookRepo;
import com.example.labemt2.service.BookServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book create(String name, Category category, List<Author> author, Integer availableCopies) {
        Book book = new Book(name, category, author, availableCopies);
        return this.bookRepo.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = this.bookRepo.findById(id).orElseThrow(RuntimeException::new);
        this.bookRepo.delete(book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Book update(Long id, String name, Category category, List<Author> author, Integer availableCopies) {
        Book book = findById(id);
        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);
        return this.bookRepo.save(book);
    }

    @Override
    public Book markAsTaken(Long id) {
        return null;
    }
}
