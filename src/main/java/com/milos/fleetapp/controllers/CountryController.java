package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.services.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/countries/addNew")
    public String addNew(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(int id){
        return countryService.findById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

}
