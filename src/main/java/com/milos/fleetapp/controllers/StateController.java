package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.models.State;
import com.milos.fleetapp.services.CountryService;
import com.milos.fleetapp.services.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    private final StateService stateService;
    private final CountryService countryService;

    public StateController(StateService stateService, CountryService countryService) {
        this.stateService = stateService;
        this.countryService = countryService;
    }

    @GetMapping("/states")
    public String getStates(Model model) {
        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "state";
    }

    @PostMapping("/states/addNew")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findStateById(int id) {
        return stateService.findById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateState(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteState(Integer id) {
        stateService.delete(id);

        return "redirect:/states";
    }

}


