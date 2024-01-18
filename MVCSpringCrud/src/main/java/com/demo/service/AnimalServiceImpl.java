package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AnimalDao;
import com.demo.model.Animal;

@Service
public class AnimalServiceImpl implements AnimalService{
	@Autowired
	private AnimalDao adao;

	@Override
	public List<Animal> getAllAnimals() {
		return adao.fetchAll();
	}

	@Override
	public Animal getById(int id) {
		return adao.getById(id);
	}

	@Override
	public void updateAni(Animal animal) {
		adao.updateAnimal(animal);
	}

}
