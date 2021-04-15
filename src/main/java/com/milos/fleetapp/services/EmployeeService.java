package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Employee;
import com.milos.fleetapp.models.User;
import com.milos.fleetapp.repositories.EmployeeRepository;
import com.milos.fleetapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public EmployeeService(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
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

    public Employee findByUserName(String username) {
        return employeeRepository.findByUserName(username);
    }

    public void assignUserName(Integer id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        User user = userRepository.findByFirstNameAndLastName(
                employee.getFirstName(),
                employee.getLastName());

        employee.setUserName(user.getUsername());

        employeeRepository.save(employee);
    }
}
