package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.VehicleMaintenance;
import com.milos.fleetapp.services.SupplierService;
import com.milos.fleetapp.services.VehicleMaintenanceService;
import com.milos.fleetapp.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    private final VehicleMaintenanceService vehicleMaintenanceService;
    private final VehicleService vehicleService;
    private final SupplierService supplierService;

    public VehicleMaintenanceController(VehicleMaintenanceService vehicleMaintenanceService, VehicleService vehicleService, SupplierService supplierService) {
        this.vehicleMaintenanceService = vehicleMaintenanceService;
        this.vehicleService = vehicleService;
        this.supplierService = supplierService;
    }
    //getAll
    @GetMapping("/vehiclemaintenances")
    public String getVehicleMaintenance(Model model) {
        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getAll();
        model.addAttribute("vehiclemaintenances", vehicleMaintenanceList);
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("vehicles", vehicleService.getVehicles());

        return "vehicleMaintenance";
    }

    //add new
    @PostMapping("/vehiclemaintenances/addNew")
    public String save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehiclemaintenances";
    }

    //find by id
    @GetMapping("/vehiclemaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceService.findById(id);
    }

    //update
    @RequestMapping(value = "/vehiclemaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehiclemaintenances";
    }

    //delete
    @RequestMapping(value = "/vehiclemaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.deleteById(id);
        return "redirect:/vehiclemaintenances";
    }
}
