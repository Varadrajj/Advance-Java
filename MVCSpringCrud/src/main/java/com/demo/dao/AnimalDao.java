package com.demo.dao;

import java.util.List;

import com.demo.model.Animal;

public interface AnimalDao {

	List<Animal> fetchAll();

	Animal getById(int id);

	void updateAnimal(Animal animal);

}
