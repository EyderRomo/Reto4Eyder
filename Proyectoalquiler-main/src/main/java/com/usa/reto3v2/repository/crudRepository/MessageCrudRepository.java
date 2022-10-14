package com.usa.reto3v2.repository.crudRepository;


import com.usa.reto3v2.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
