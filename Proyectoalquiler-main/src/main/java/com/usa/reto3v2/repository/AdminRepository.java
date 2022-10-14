package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Admin;
import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.repository.crudRepository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

@Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin administrador) {
        return adminCrudRepository.save(administrador);
    }

    public void delete(Admin administrador) {
        adminCrudRepository.delete(administrador);
    }
}
