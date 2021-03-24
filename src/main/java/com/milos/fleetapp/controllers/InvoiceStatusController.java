package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.InvoiceStatus;
import com.milos.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    private final InvoiceStatusRepository invoiceStatusRepository;

    public InvoiceStatusController(InvoiceStatusRepository invoiceStatusRepository) {
        this.invoiceStatusRepository = invoiceStatusRepository;
    }

    //get all
    @GetMapping("/invoicestatus")
    public String getInvoiceStatus(Model model) {
        List<InvoiceStatus> invoiceStatusList = invoiceStatusRepository.findAll();
        model.addAttribute("invoicestatus", invoiceStatusList);
        return "invoiceStatus";
    }

    //addNew
    @PostMapping("/invoicestatus/addNew")
    public String addNewIS(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
        return "redirect:/invoicestatus";
    }

    //find InvoiceStatusById
    @GetMapping("/invoicestatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findISById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    //update
    @RequestMapping(value = "/invoicestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateIS(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
        return "redirect:/invoicestatus";
    }

    //delete
    @RequestMapping(value = "/invoicestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteIS(Integer id) {
        invoiceStatusRepository.deleteById(id);
        return "redirect:/invoicestatus";
    }
}
