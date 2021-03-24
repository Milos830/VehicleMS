package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleModel;
import com.milos.fleetapp.models.VehicleType;
import com.milos.fleetapp.services.VehicleModelService;
import com.milos.fleetapp.services.VehicleTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    private final VehicleModelService vehicleModelService;

    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    //get all locations in table on web page
    @GetMapping("/vehiclemodels")
    public String getVM(Model model) {
        List<VehicleModel> vehicleModelsList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehiclemodels", vehicleModelsList);

        return "vehicleModel";
    }

    @PostMapping("/vehiclemodels/addNew")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehiclemodels";
    }

    @GetMapping("/vehiclemodels/findById")
    @ResponseBody
    public Optional<VehicleModel> findVehicleModelById(Integer id) {
        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "/vehiclemodels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehiclemodels";
    }

    @RequestMapping(value = "/vehiclemodels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleModelService.deleteVehicleModelById(id);
        return "redirect:/vehiclemodels";
    }

}


