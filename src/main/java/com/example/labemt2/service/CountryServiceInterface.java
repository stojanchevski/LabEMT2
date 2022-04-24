package com.example.labemt2.service;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Country;

import java.util.List;

public interface CountryServiceInterface {

    List<Country> listAll();

    Country create(String name, String continent);

    Country delete(Long id);

    Country findById(Long id);

    Country update(Long id,String name, String continent);
}
