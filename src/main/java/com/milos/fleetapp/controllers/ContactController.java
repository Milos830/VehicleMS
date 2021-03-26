package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Contact;
import com.milos.fleetapp.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
//get all contacts
    @GetMapping("/contacts")
    public String getContacts(Model model) {
        List<Contact> contactList = contactService.getContacts();
        model.addAttribute("contacts", contactList);
        return "contact";
    }


    //save new
    @PostMapping("/contacts/addNew")
    public String saveNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    //find by id
    @GetMapping("/contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id) {
        return contactService.findById(id);
    }

    //update
    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    //delete
    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
