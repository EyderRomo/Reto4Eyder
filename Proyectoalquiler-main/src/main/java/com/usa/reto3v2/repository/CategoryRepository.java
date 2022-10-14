package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

 @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category categoria) {
        return categoryCrudRepository.save(categoria);
    }

    public void delete(Category categoria) {
        categoryCrudRepository.delete(categoria);
    }
}
