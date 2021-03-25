package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Invoice;
import com.milos.fleetapp.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    //get all
    public List<Invoice> getInvoices () {
        return invoiceRepository.findAll();
    }

    //save new
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    //get by id
    public Optional<Invoice> getById(Integer id) {
        return invoiceRepository.findById(id);
    }

    //delete by id
    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
