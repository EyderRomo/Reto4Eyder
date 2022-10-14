package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Admin;
import com.usa.reto3v2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }


    public Admin save(Admin administrador) {
        if (administrador.getId() == null) {
            return adminRepository.save(administrador);
        } else {
            Optional<Admin> a = adminRepository.getAdmin(administrador.getId());
            if (a.isPresent()) {
                return a.get();
            } else {
                return adminRepository.save(administrador);
            }
        }
    }

    public Admin Update(Admin adm) {
        if (adm.getId() != null) {
            Optional<Admin> ad = adminRepository.getAdmin(adm.getId());
            if (ad.isPresent()) {
                if (adm.getName() != null) {
                    ad.get().setName(adm.getName());
                }
                if (adm.getEmail() != null) {
                    ad.get().setEmail(adm.getEmail());
                }
                if (adm.getPassword() != null) {
                    ad.get().setPassword(adm.getPassword());
                }

                adminRepository.save(ad.get());
                return ad.get();

            } else {
                return adm;
            }
        } else {
            return adm;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(int id) {
        boolean marca = false;
        Optional<Admin> a = adminRepository.getAdmin(id);
        if (a.isPresent()) {
            adminRepository.delete(a.get());
            marca = true;
        }
        return marca;

    }
}