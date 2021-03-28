package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleHire;
import com.milos.fleetapp.services.ClientService;
import com.milos.fleetapp.services.LocationService;
import com.milos.fleetapp.services.VehicleHireService;
import com.milos.fleetapp.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleHireController {

    private final ClientService clientService;
    private final LocationService locationService;
    private final VehicleService vehicleService;
    private final VehicleHireService vehicleHireService;

    public VehicleHireController(ClientService clientService, LocationService locationService,
                                 VehicleService vehicleService, VehicleHireService vehicleHireService) {
        this.clientService = clientService;
        this.locationService = locationService;
        this.vehicleService = vehicleService;
        this.vehicleHireService = vehicleHireService;
    }

    //get all
    @GetMapping("/vehiclehires")
    public String getVehicleHire(Model model) {
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("vehiclehires", vehicleHireService.getAll());

        return "vehicleHire";
    }

    //add new
    @PostMapping("/vehiclehires/addNew")
    public String save(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehires";
    }

    //find by id
    @GetMapping("/vehiclehires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(Integer id) {
       return vehicleHireService.findById(id);
    }

    //update
    @RequestMapping(value = "/vehiclehires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehires";
    }

    //delete by id
    @RequestMapping(value = "/vehiclehires/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleHireService.deleteById(id);
        return "redirect:/vehiclehires";
    }
}
