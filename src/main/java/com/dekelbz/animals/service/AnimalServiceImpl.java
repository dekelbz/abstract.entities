package com.dekelbz.animals.service;

import com.dekelbz.animals.entity.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    public static final String ANIMAL_GET_BY_ID = "animal-get-by-id";
    public static final String ANIMAL_SAVE = "animal-save";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    @Transactional
    public void save(Animal animal) {
        kafkaTemplate.send(ANIMAL_SAVE, animal);
    }

    @Override
    public void getById(Long id) {
        kafkaTemplate.send(ANIMAL_GET_BY_ID, id);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
