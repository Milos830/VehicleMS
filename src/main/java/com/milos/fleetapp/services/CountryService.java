package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
