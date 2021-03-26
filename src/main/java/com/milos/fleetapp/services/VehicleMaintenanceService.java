package com.milos.fleetapp.services;

import com.milos.fleetapp.models.VehicleMaintenance;
import com.milos.fleetapp.repositories.VehicleMaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public VehicleMaintenanceService(VehicleMaintenanceRepository vehicleMaintenanceRepository) {
        this.vehicleMaintenanceRepository = vehicleMaintenanceRepository;
    }


    //getAll
    public List<VehicleMaintenance> getAll(){
        return vehicleMaintenanceRepository.findAll();
    }

    //save new

    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    //find by id
    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceRepository.findById(id);
    }

    //delete
    public void deleteById(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }
}
