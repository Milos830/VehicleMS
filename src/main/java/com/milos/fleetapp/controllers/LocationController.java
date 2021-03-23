package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Country;
import com.milos.fleetapp.models.Location;
import com.milos.fleetapp.models.State;
import com.milos.fleetapp.services.CountryService;
import com.milos.fleetapp.services.LocationService;
import com.milos.fleetapp.services.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    public static final String LOCATION_Locations_URL = "redirect:/locations";
    private final LocationService locationService;
    private final CountryService countryService;
    private final StateService stateService;

    public LocationController(LocationService locationService, CountryService countryService, StateService stateService) {
        this.locationService = locationService;
        this.countryService = countryService;
        this.stateService = stateService;
    }
        //get all locations in table on web page
    @GetMapping("/locations")
    public String getLocations(Model model) {
        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        return "location";
    }

    @PostMapping("/locations/addNew")
    public String addNewLocation(Location location) {
        locationService.saveLocation(location);
        return LOCATION_Locations_URL;
    }

    @GetMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findLocationById(Integer id) {
       return locationService.findLocationById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLocation(Location location) {
        locationService.saveLocation(location);
        return LOCATION_Locations_URL;
    }
    
    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLocation(Integer id) {
        locationService.deleteLocationById(id);
        return LOCATION_Locations_URL;
    }
}
