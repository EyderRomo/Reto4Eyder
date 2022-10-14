package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message save(Message mensaje) {
        return messageCrudRepository.save(mensaje);
    }

    public void delete(Message mensaje) {
        messageCrudRepository.delete(mensaje);
    }
}
