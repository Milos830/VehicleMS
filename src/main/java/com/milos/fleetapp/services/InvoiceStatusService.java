package com.milos.fleetapp.services;

import com.milos.fleetapp.models.InvoiceStatus;
import com.milos.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    private final InvoiceStatusRepository invoiceStatusRepository;

    public InvoiceStatusService(InvoiceStatusRepository invoiceStatusRepository) {
        this.invoiceStatusRepository = invoiceStatusRepository;
    }

    //get all statuses
    public List<InvoiceStatus> getInvoiceStatuses () {
        return invoiceStatusRepository.findAll();
    }

    //save status
    public void saveInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    //find by id
    public Optional<InvoiceStatus> findInvoiceStatusById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    //delete by id
    public void deleteInvoiceStatus(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
