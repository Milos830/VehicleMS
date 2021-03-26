package com.milos.fleetapp.services;


import com.milos.fleetapp.models.VehicleMovement;
import com.milos.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMovementService {

    private final VehicleMovementRepository vehicleMovementRepository;

    public VehicleMovementService(VehicleMovementRepository vehicleMovementRepository) {
        this.vehicleMovementRepository = vehicleMovementRepository;
    }

    //getAll
    public List<VehicleMovement> getVM () {
        return vehicleMovementRepository.findAll();
    }

    //save new
    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    //find by id
    public VehicleMovement findById(Integer id) {
        return vehicleMovementRepository.findById(id).orElse(null);
    }

    //delete by id
    public void deleteByIdVM(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }
}
