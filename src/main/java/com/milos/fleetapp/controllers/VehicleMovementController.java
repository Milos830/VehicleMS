package com.milos.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {

    @GetMapping("/vehiclemovements")
    public String getVehicleMovement() {
        return "vehicleMovement";
    }
}
