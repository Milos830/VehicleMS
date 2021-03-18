package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
        // this method get list of all the countries
    public List<Country> getCountries () {
        return countryRepository.findAll();
    }

    //save new country
    public void save(Country country) {
        countryRepository.save(country);
    }

    //return country by id
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);

    }

}
