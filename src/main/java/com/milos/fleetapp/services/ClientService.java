package com.milos.fleetapp.services;

import com.milos.fleetapp.models.Client;
import com.milos.fleetapp.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //getAll
    public List<Client> getClients () {
        return clientRepository.findAll();
    }

    //save new
    public void save(Client client) {
        clientRepository.save(client);
    }

    //find by id
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    //delete by id
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }
}
