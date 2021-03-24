package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleStatus;
import com.milos.fleetapp.services.VehicleStatusService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {


    private final VehicleStatusService vehicleStatusService;

    public VehicleStatusController(VehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @GetMapping("/vehiclestatuses")
    public String getVehicleStatus(Model model) {
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehiclestatuses", vehicleStatusList);

        return "vehicleStatus";
    }

    @PostMapping("/vehiclestatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.saveVehicleStatus(vehicleStatus);
        return "redirect:/vehiclestatuses";
    }
    //find by id
    @GetMapping("/vehiclestatuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findVSById(Integer id) {
        return vehicleStatusService.vehicleStatusFindById(id);
    }

//    update
    @RequestMapping(value = "/vehiclestatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVS(VehicleStatus vehicleStatus) {
        vehicleStatusService.saveVehicleStatus(vehicleStatus);
        return "redirect:/vehiclestatuses";
    }

    @RequestMapping(value = "/vehiclestatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVS (Integer id) {
        vehicleStatusService.deleteVehicleStatusById(id);
        return "redirect:/vehiclestatuses";
    }
}
