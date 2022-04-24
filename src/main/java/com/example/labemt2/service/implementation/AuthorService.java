package com.example.labemt2.service.implementation;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Country;
import com.example.labemt2.repository.AuthorRepo;
import com.example.labemt2.service.AuthorServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements AuthorServiceInterface {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepo.findAll();
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name,surname,country);
        return authorRepo.save(author);
    }

    @Override
    public Author delete(Long id) {
        Author author = this.authorRepo.findById(id).orElseThrow(RuntimeException::new);
        this.authorRepo.delete(author);
        return author;
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Author update(Long id, String name, String surname, Country country) {
        Author author = findById(id);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return this.authorRepo.save(author);
    }
}
