package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.repository.crudRepository.MotorbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class MotorbikeRepository {

    @Autowired
    private MotorbikeCrudRepository motorbikeCrudRepository;

    public List<Motorbike> getAll() {
        return (List<Motorbike>) motorbikeCrudRepository.findAll();
    }

    public Optional<Motorbike> getMotorbike(int id) {
        return motorbikeCrudRepository.findById(id);
    }

    public Motorbike save(Motorbike moto) {
        return motorbikeCrudRepository.save(moto);
    }

    public void delete(Motorbike moto) {
        motorbikeCrudRepository.delete(moto);
    }
}
