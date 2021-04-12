package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.User;
import com.milos.fleetapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers() {
        return "user";
    }
//Modified  method to Add a new user User

    @PostMapping(value = "users/addNew")
    public RedirectView addNewUser(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You have been successfully registered! You can now login!");
        return redirectView;
    }
}
