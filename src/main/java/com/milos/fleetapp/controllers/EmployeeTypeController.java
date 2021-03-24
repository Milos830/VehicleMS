package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.EmployeeType;
import com.milos.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeController(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

//    get all Types

    @GetMapping("/employeetypes")
    public String getEmployeeTypes(Model model) {
        List<EmployeeType> employeeTypeList = employeeTypeRepository.findAll();
        model.addAttribute("employeetypes", employeeTypeList);
        return "employeeType";
    }

    //addNew empType
    @PostMapping("/employeetypes/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
        return "redirect:/employeetypes";
    }

    //findById empType
    @GetMapping("/employeetypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    //update empType
    @RequestMapping(value = "/employeetypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmpType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
        return "redirect:/employeetypes";
    }

    //delete empTypeById
    @RequestMapping(value = "/employeetypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmpType(Integer id) {
        employeeTypeRepository.deleteById(id);
        return "redirect:/employeetypes";
    }
}
