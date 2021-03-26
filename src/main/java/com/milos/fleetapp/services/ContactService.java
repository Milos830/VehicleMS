package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Contact;
import com.milos.fleetapp.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    //get all
    public List<Contact> getContacts (){
       return contactRepository.findAll();
    }

    //save
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    //find by id
    public Optional<Contact> findById(Integer id) {
       return contactRepository.findById(id);
    }

    //delete by id
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }


}
