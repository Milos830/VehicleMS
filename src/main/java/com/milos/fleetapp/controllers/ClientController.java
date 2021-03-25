package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Client;
import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.models.State;
import com.milos.fleetapp.services.ClientService;
import com.milos.fleetapp.services.CountryService;
import com.milos.fleetapp.services.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final CountryService countryService;
    private final StateService stateService;

    public ClientController(ClientService clientService, CountryService countryService, StateService stateService) {
        this.clientService = clientService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        return "client";
    }

    @PostMapping("/clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }
}
