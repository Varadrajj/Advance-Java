package com.demo.service;

import java.util.List;

import com.demo.model.Animal;

public interface AnimalService {

	List<Animal> getAllAnimals();

	Animal getById(int id);

	void updateAni(Animal animal);

}
