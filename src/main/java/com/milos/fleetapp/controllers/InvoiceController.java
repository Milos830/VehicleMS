package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.Client;
import com.milos.fleetapp.models.Invoice;
import com.milos.fleetapp.models.InvoiceStatus;
import com.milos.fleetapp.services.ClientService;
import com.milos.fleetapp.services.InvoiceService;
import com.milos.fleetapp.services.InvoiceStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final ClientService clientService;
    private final InvoiceStatusService invoiceStatusService;

    public InvoiceController(InvoiceService invoiceService, ClientService clientService, InvoiceStatusService invoiceStatusService) {
        this.invoiceService = invoiceService;
        this.clientService = clientService;
        this.invoiceStatusService = invoiceStatusService;
    }

    //get all invoices
    @GetMapping("/invoices")
    public  String getInvoices(Model model) {
        List<Invoice> invoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices", invoiceList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoicestatus", invoiceStatusList);
        return "invoice";
    }

    //save new invoice

    @PostMapping("/invoices/addNew")
    public String saveNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id){
        return invoiceService.getById(id);
    }

    //update
    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoice(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    //delete by id
    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoice(Integer id){
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
