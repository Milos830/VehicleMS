package com.milos.fleetapp.services;

import com.milos.fleetapp.models.VehicleStatus;
import com.milos.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;

    public VehicleStatusService(VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    //get all
    public List<VehicleStatus> getVehicleStatus () {
        return vehicleStatusRepository.findAll();
    }

    // find by id
    public Optional<VehicleStatus> vehicleStatusFindById(Integer id) {
        return vehicleStatusRepository.findById(id);
    }

    //save
    public void saveVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    //delete by id
    public void deleteVehicleStatusById(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }

}
