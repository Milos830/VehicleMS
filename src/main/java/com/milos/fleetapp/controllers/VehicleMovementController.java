package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleMovement;
import com.milos.fleetapp.services.LocationService;
import com.milos.fleetapp.services.VehicleMovementService;
import com.milos.fleetapp.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleMovementController {

    private final VehicleMovementService vehicleMovementService;
    private final VehicleService vehicleService;
    private final LocationService locationService;

    public VehicleMovementController(VehicleMovementService vehicleMovementService, VehicleService vehicleService, LocationService locationService) {
        this.vehicleMovementService = vehicleMovementService;
        this.vehicleService = vehicleService;
        this.locationService = locationService;
    }

    //get all
    @GetMapping("/vehiclemovements")
    public String getVehicleMovement(Model model) {

        model.addAttribute("vehiclemovements", vehicleMovementService.getVM());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        return "vehicleMovement";
    }

    //add New
    @PostMapping("/vehiclemovements/addNew")
    public String saveNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehiclemovements";
    }

    // find by id
    @GetMapping("/vehiclemovements/findById")
    @ResponseBody
    public VehicleMovement findById(Integer id){
        return vehicleMovementService.findById(id);
    }

    //update
    @RequestMapping(value = "/vehiclemovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehiclemovements";
    }

    //delete by id
    @RequestMapping(value = "/vehiclemovements/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.deleteByIdVM(id);
        return "redirect:/vehiclemovements";
    }
}
