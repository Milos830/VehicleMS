package com.milos.fleetapp.services;


import com.milos.fleetapp.models.VehicleHire;
import com.milos.fleetapp.repositories.VehicleHireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleHireService {

    private final VehicleHireRepository vehicleHireRepository;


    public VehicleHireService(VehicleHireRepository vehicleHireRepository) {
        this.vehicleHireRepository = vehicleHireRepository;
    }

    //get all

    public List<VehicleHire> getAll(){
       return vehicleHireRepository.findAll();
    }

    //save new

    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    //find by id
    public Optional<VehicleHire> findById(Integer id) {
        return  vehicleHireRepository.findById(id);
    }

    //delete by id
    public void deleteById(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
