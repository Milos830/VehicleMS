package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Vehicle;
import com.milos.fleetapp.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {

    private final EmployeeService employeeService;
    private final LocationService locationService;
    private final VehicleMakeService vehicleMakeService;
    private final VehicleModelService vehicleModelService;
    private final VehicleStatusService vehicleStatusService;
    private final VehicleTypeService vehicleTypeService;
    private final VehicleService vehicleService;

    public VehicleController(EmployeeService employeeService, LocationService locationService,
                             VehicleMakeService vehicleMakeService, VehicleModelService vehicleModelService,
                             VehicleStatusService vehicleStatusService, VehicleTypeService vehicleTypeService, VehicleService vehicleService) {
        this.employeeService = employeeService;
        this.locationService = locationService;
        this.vehicleMakeService = vehicleMakeService;
        this.vehicleModelService = vehicleModelService;
        this.vehicleStatusService = vehicleStatusService;
        this.vehicleTypeService = vehicleTypeService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public String getVehicles(Model model) {

        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("vehiclemakes", vehicleMakeService.getVehicleMake());
        model.addAttribute("vehiclemodels", vehicleModelService.getVehicleModels());
        model.addAttribute("vehiclestatuses", vehicleStatusService.getVehicleStatus());
        model.addAttribute("vehicletypes", vehicleTypeService.getVehicleType());

        model.addAttribute("vehicles", vehicleService.getVehicles());

        return "vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id) {
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update (Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleService.deleteById(id);
        return "redirect:/vehicles";
    }
}
