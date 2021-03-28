package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Vehicle;
import com.milos.fleetapp.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Vehicle> findById(Integer id) {
        return  vehicleRepository.findById(id);
    }

    //delete by id
    public void deleteById(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
