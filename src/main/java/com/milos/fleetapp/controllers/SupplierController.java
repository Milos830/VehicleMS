package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.models.State;
import com.milos.fleetapp.models.Supplier;
import com.milos.fleetapp.services.CountryService;
import com.milos.fleetapp.services.StateService;
import com.milos.fleetapp.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    private final SupplierService supplierService;
    private final CountryService countryService;
    private final StateService stateService;

    public SupplierController(SupplierService supplierService, CountryService countryService, StateService stateService) {
        this.supplierService = supplierService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    //get all
    @GetMapping("/suppliers")
    public  String getSuppliers(Model model) {
        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", supplierList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        return "supplier";
    }

    //save new Supplier
    @PostMapping("/suppliers/addNew")
    public String saveNew(Supplier supplier) {
        supplierService.saveNew(supplier);
        return "redirect:/suppliers";
    }

    //get by id
    @GetMapping("/suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id) {
        return supplierService.findById(id);
    }

    //update
    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.saveNew(supplier);
        return "redirect:/suppliers";
    }

    //delete
    @RequestMapping(value = "/suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }
}
