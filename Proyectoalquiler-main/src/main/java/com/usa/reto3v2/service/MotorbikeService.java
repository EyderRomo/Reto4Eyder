package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll() {
        return motorbikeRepository.getAll();
    }

    public Motorbike get(Integer id) {
        return motorbikeRepository.getMotorbike(id).get();
    }

    public Optional<Motorbike> getMotorbike(int id) {
        return motorbikeRepository.getMotorbike(id);
    }

    public Motorbike save(Motorbike moto) {
        if (moto.getId() == null) {
            return motorbikeRepository.save(moto);
        } else {
            Optional<Motorbike> m = motorbikeRepository.getMotorbike(moto.getId());
            if (m.isPresent()) {
                return moto;
            } else {
                return motorbikeRepository.save(moto);
            }
        }
    }

    public Motorbike update(Motorbike moto){
        if(moto.getId()!=null){
            Optional<Motorbike> q = motorbikeRepository.getMotorbike(moto.getId());
            if(q.isPresent()){
                if(moto.getBrand()!=null){
                    q.get().setBrand(moto.getBrand());
                }
                if(moto.getName()!=null){
                    q.get().setName(moto.getName());
                }
                if(moto.getYear()!=null){
                    q.get().setYear(moto.getYear());
                }
                if(moto.getDescription()!=null){
                    q.get().setDescription(moto.getDescription());
                }
                if(moto.getCategory()!=null){
                    q.get().setCategory(moto.getCategory());
                }
                if(moto.getMessages()!=null){
                    q.get().setMessages(moto.getMessages());
                }
                if(moto.getReservations()!=null){
                    q.get().setReservations(moto.getReservations());
                }
                motorbikeRepository.save(q.get());
                return q.get();
            }else{
                return moto;
            }
        }else{
            return moto;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(int id){
        boolean flag=false;
        Optional<Motorbike>p= motorbikeRepository.getMotorbike(id);
        if(p.isPresent()){
            motorbikeRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
