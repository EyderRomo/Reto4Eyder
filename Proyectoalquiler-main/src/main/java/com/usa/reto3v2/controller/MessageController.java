package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Admin;
import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message ad) {
        return messageService.save(ad);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Message> getAllClient2() {
        return messageService.getAll();
    }


    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable Integer idMessage) {
        return messageService.delete(idMessage);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateMessage(@RequestBody Message message) {
        return messageService.Update(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@PathVariable Integer id) {
        Message message;
        try {
            message = messageService.getMessage(id).get();
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}