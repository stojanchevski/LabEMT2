package com.example.labemt2.service;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Book;
import com.example.labemt2.model.Category;
import com.example.labemt2.model.Country;

import java.util.List;

public interface AuthorServiceInterface {

    List<Author> listAll();

    Author create(String name, String surname, Country country);

    Author delete(Long id);

    Author findById(Long id);

    Author update(Long id,String name, String surname, Country country);

}
