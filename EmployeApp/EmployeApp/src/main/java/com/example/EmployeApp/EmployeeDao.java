package com.example.EmployeApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	@Autowired
	MyRepository repository;

	public List<Employee> fetch() {
		List<Employee> data = repository.findAll();
		return data;
	}

	public boolean add(Employee e) {
		try {
			repository.save(e);
			return true;
		} catch (Exception op) {
			System.out.println(op.getMessage());
			return false;
		}
	}

	public void deleteAll(List<Employee> data) {
		repository.deleteAll(data);
	}

	public Optional<Employee> fetchData(int id) {
		try {
			Optional<Employee> data = repository.findById(id);
			return data;
		} catch (Exception e) {
			System.out.println("no record found");
			return null;
		}
	}

	public void update(Employee e) {
		repository.save(e);
	}

	public void deleteRecord(int delete) {
		try {
		repository.deleteById(delete);
		return;
		}
		catch (Exception e) {
			System.out.println("No record found");
		}
	}
}
