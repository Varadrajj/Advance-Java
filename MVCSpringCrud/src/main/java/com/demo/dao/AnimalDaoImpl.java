package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Animal;

@Repository
public class AnimalDaoImpl implements AnimalDao{
	@Autowired
	private JdbcTemplate jd;

	@Override
	public List<Animal> fetchAll() {
		return jd.query("select * from animal", (rs, num) -> {
			Animal a = new Animal();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setAge(rs.getInt(3));
			return a;
		});
	}

	@Override
	public Animal getById(int id) {
		return jd.queryForObject("select * from animal where id = ?", new Object[] {id}, BeanPropertyRowMapper.newInstance(Animal.class));
	}

	@Override
	public void updateAnimal(Animal animal) {
		jd.update("update animal set name = ?, age = ? where id = ?", new Object[] {animal.getName(), animal.getAge(), animal.getId()});
	}

}
