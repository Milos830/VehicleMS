package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.services.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String getCountry(Model model) {

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        return "country";
    }


}
