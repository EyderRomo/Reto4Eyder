package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message mensaje) {
        if (mensaje.getIdMessage() == null) {
            return messageRepository.save(mensaje);
        } else {
            Optional<Message> m = messageRepository.getMessage(mensaje.getIdMessage());
            if (m.isPresent()) {
                return mensaje;
            } else {
                return messageRepository.save(mensaje);
            }
        }
    }

    public Message Update(Message mensaje) {
        if (mensaje.getIdMessage() != null) {
            Optional<Message> ms = messageRepository.getMessage(mensaje.getIdMessage());
            if (ms.isPresent()) {
                if (mensaje.getMessageText() != null) {
                    ms.get().setMessageText(mensaje.getMessageText());
                }
                if (mensaje.getMotorbike() != null) {
                    ms.get().setMotorbike(mensaje.getMotorbike());
                }
                if (mensaje.getClient() != null) {
                    ms.get().setClient(mensaje.getClient());
                }


                messageRepository.save(ms.get());
                return ms.get();

            } else {
                return mensaje;
            }
        } else {
            return mensaje;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(int id){
        boolean flag=false;
        Optional<Message>p= messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

