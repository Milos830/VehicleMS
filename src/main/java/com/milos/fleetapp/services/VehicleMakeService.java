package com.milos.fleetapp.services;

import com.milos.fleetapp.models.VehicleMake;
import com.milos.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    private final VehicleMakeRepository vehicleMakeRepository;

    public VehicleMakeService(VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    //get list of Vehicle makes

    public List<VehicleMake> getVehicleMake() {
        return vehicleMakeRepository.findAll();
    }
    //save
    public void saveVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    //get by id
    public Optional<VehicleMake> findVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findById(id);
    }

    //delete by id
    public void deleteVehicleMakeById(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
