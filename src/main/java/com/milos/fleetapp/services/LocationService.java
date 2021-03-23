package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Location;
import com.milos.fleetapp.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
        //get list of Locations
    public List<Location> getLocations () {
       return locationRepository.findAll();
    }
    //save Location
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }
    //find Location by id
    public Optional<Location> findLocationById(Integer id) {
        return locationRepository.findById(id);
    }
    //delete Location by id
    public void deleteLocationById(Integer id) {
        locationRepository.deleteById(id);
    }
}
