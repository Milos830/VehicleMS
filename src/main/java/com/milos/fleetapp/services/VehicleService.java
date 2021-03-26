package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Vehicle;
import com.milos.fleetapp.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    //get All
    public List<Vehicle> getVehicles () {
       return vehicleRepository.findAll();
    }

    //save new
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    //find by id
    public Vehicle findById(Integer id) {
        return  vehicleRepository.findById(id).orElse(null);
    }

    //delete by id
    public void deleteById(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
