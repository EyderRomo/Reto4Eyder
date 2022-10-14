package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category p) {
        if (p.getId() == null) {
            return categoryRepository.save(p);
        } else {
            Optional<Category> c = categoryRepository.getCategory(p.getId());
            if (c.isPresent()) {
                return p;
            } else {
                return categoryRepository.save(p);
            }
        }
    }

    public Category update(Category p) {
        if (p.getId() != null) {
            Optional<Category> ct = categoryRepository.getCategory(p.getId());
            if (ct.isPresent()) {
                if (p.getName() != null) {
                    ct.get().setName(p.getName());
                }
                if (p.getDescription() != null) {
                    ct.get().setDescription(p.getDescription());
                }
                if (p.getMotorbikes() != null) {
                    ct.get().setMotorbikes(p.getMotorbikes());
                }
                categoryRepository.save(ct.get());
                return ct.get();
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
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
