package com.milos.fleetapp.controllers;

import com.milos.fleetapp.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private final EmployeeService employeeService;

    public ProfileController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/profile")
    public String getProfile(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("employee", employeeService.findByUserName(username));
        return "profile";
    }


}
