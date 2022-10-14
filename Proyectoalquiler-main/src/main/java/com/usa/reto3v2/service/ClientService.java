package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client p) {
        if (p.getIdClient() == null) {
            return clientRepository.save(p);
        } else {
            Optional<Client> a = clientRepository.getClient(p.getIdClient());
            if (a.isPresent()) {
                return p;
            } else {
                return clientRepository.save(p);
            }
        }
    }

    public Client update(Client p) {
        if (p.getIdClient() != null) {
            Optional<Client> c = clientRepository.getClient(p.getIdClient());
            if (c.isPresent()) {
                if (p.getName() != null) {
                    c.get().setName(p.getName());
                }
                if (p.getEmail() != null) {
                    c.get().setEmail(p.getEmail());
                }
                if (p.getPassword() != null) {
                    c.get().setPassword(p.getPassword());
                }
                if (p.getAge() != null) {
                    c.get().setAge(p.getAge());
                }
                if (p.getMessages() != null) {
                    c.get().setMessages(p.getMessages());
                }
                if (p.getReservations() != null) {
                    c.get().setReservations(p.getReservations());
                }
                clientRepository.save(c.get());
                return c.get();

            } else {
                return p;
            }
        } else {
            return p;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
