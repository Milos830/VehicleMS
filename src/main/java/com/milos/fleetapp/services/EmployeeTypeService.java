package com.milos.fleetapp.services;

import com.milos.fleetapp.models.EmployeeType;
import com.milos.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeService(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    //get all employeeTypes
    public List<EmployeeType> getAllEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    //save
    public void saveEmployeeType(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    //get employee Type by id
    public Optional<EmployeeType> getEmployeeTypeById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    //delete by id
    public void deleteEmployeeType(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
