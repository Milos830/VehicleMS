package com.milos.fleetapp.services;

import com.milos.fleetapp.models.VehicleModel;
import com.milos.fleetapp.repositories.VehicleModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;

    public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    //get all Vehicle Models
    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    //save
    public void saveVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    //find by id
    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelRepository.findById(id);
    }

    //delete by id
    public void deleteVehicleModelById(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
