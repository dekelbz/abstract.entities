package com.dekelbz.animals.service;

import com.dekelbz.animals.entity.Animal;

public interface AnimalService {
     void save(Animal animal);

    void getById(Long id);

    boolean delete(Long id);
}
