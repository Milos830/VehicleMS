package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Supplier;
import com.milos.fleetapp.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    //getAll
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    //saveNew
    public void saveNew(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    //get by id
    public Optional<Supplier> findById(Integer id) {
        return supplierRepository.findById(id);
    }

    //delete by id
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }
}
