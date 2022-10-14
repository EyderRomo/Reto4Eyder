package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Reservation;
import com.usa.reto3v2.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservacion) {
        return reservationCrudRepository.save(reservacion);
    }

    public void delete(Reservation reservacion) {
        reservationCrudRepository.delete(reservacion);
    }
}
