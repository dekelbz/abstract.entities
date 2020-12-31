package com.dekelbz.animals.controller;

import com.dekelbz.animals.entity.Animal;
import com.dekelbz.animals.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AnimalController {

	private final AnimalService animalService;

	@MessageMapping("/getbyid")
	public void getById(Long id) throws Exception {
		animalService.getById(id);
	}

	@MessageMapping("/save")
	public void save(Animal animal) {
		animalService.save(animal);
	}

}
