package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
@Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public Client save(Client firstClient) {
        return clientCrudRepository.save(firstClient);
    }

    public void delete(Client firstClient) {
        clientCrudRepository.delete(firstClient);
    }
}
