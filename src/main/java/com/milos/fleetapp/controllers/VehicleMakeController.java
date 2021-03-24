package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleMake;
import com.milos.fleetapp.services.VehicleMakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    private final VehicleMakeService vehicleMakeService;

    public VehicleMakeController(VehicleMakeService vehicleMakeService) {
        this.vehicleMakeService = vehicleMakeService;
    }

    //get all
    @GetMapping("/vehiclemakes")
    public String getVehicleMake(Model model) {

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMake();
        model.addAttribute("vehiclemakes", vehicleMakeList);
        return "vehicleMake";
    }

    //save new
    @PostMapping("/vehiclemakes/addNew")
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/vehiclemakes";
    }
    //update vehicleMake
    @RequestMapping(value = "/vehiclemakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/vehiclemakes";
    }
    //find by id
    @GetMapping("vehiclemakes/findById/")
    @ResponseBody
    public Optional<VehicleMake> findVehicleMake(Integer id) {
        return vehicleMakeService.findVehicleMakeById(id);
    }

    @RequestMapping(value = "/vehiclemakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMake(Integer id) {
        vehicleMakeService.deleteVehicleMakeById(id);
        return "redirect:/vehiclemakes";
    }
}
