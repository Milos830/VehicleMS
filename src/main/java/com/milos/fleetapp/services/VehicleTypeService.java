package com.milos.fleetapp.services;

import com.milos.fleetapp.models.VehicleType;
import com.milos.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    //get Vehicle Type

    public List<VehicleType> getVehicleType() {
        return vehicleTypeRepository.findAll();
    }

    //save

    public void saveVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    //find by Id
    public Optional<VehicleType> findVehicleTypeById(Integer id) {
        return vehicleTypeRepository.findById(id);
    }
    //delete by id
    public void deleteVehicleType(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
