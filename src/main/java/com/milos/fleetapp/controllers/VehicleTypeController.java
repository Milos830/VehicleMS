package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleType;

import com.milos.fleetapp.services.VehicleTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    //get all locations in table on web page
    @GetMapping("/vehicletypes")
    public String getVT(Model model) {
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
        model.addAttribute("vehicletypes", vehicleTypeList);

        return "vehicleType";
    }

    @PostMapping("/vehicletypes/addNew")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);
        return "redirect:/vehicletypes";
    }

    @GetMapping("vehicletypes/findById")
    @ResponseBody
    public Optional<VehicleType> findVehicleTypesById(Integer id) {
        return vehicleTypeService.findVehicleTypeById(id);
    }

    @RequestMapping(value = "/vehicletypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);
        return "redirect:/vehicletypes";
    }

    @RequestMapping(value = "/vehicletypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleTypeService.deleteVehicleType(id);
        return "redirect:/vehicletypes";
    }
}
