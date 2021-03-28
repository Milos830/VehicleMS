package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Employee;
import com.milos.fleetapp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //get all
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    //save new
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //find by id
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    //delete by id
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
