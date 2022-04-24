package com.example.labemt2.service.implementation;

import com.example.labemt2.model.Author;
import com.example.labemt2.model.Country;
import com.example.labemt2.repository.CountryRepo;
import com.example.labemt2.service.CountryServiceInterface;

import java.util.List;

public class CountryService implements CountryServiceInterface {

    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepo.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name,continent);
        return this.countryRepo.save(country);
    }

    @Override
    public Country delete(Long id) {
        Country country = this.countryRepo.findById(id).orElseThrow(RuntimeException::new);
        this.countryRepo.delete(country);
        return country;
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country country = findById(id);
        country.setName(name);
        country.setContinent(continent);
        return this.countryRepo.save(country);
    }
}
