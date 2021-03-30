package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Employee;
import com.milos.fleetapp.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeTypeService employeeTypeService;
    private final JobTitleService jobTitleService;
    private final CountryService countryService;
    private final StateService stateService;

    public EmployeeController(EmployeeService employeeService, EmployeeTypeService employeeTypeService,
                              JobTitleService jobTitleService, CountryService countryService, StateService stateService) {
        this.employeeService = employeeService;
        this.employeeTypeService = employeeTypeService;
        this.jobTitleService = jobTitleService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("employeetypes", employeeTypeService.getAllEmployeeTypes());
        model.addAttribute("jobtitles", jobTitleService.getJobTitles());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "employee";
    }

    @PostMapping("/employees/addNew")
    public String saveNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

}
