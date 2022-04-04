package com.tns.placementManagementSystem.restFullAPIs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entities.Student;
import com.tns.placementManagementSystem.restFullAPIs.repository.StudentRepository;


//this annotation is for generic stereotype for any Spring-managed component.
@Component
public class ServiceStudent {

	// This annotation is used to inject dependences
	@Autowired(required=true)
	private StudentRepository repo; // Instance variable

	// service method to find all data from Data Base
	public List<Student> listAll() {
		return (List<Student>) repo.findAll();
	}

	// service method to save data in Data Base
	public void save(Student student) {
		repo.save(student);

	}

	// service method to find data by primary key from Data Base
	public Student getstudent(Long id) {

		return repo.findById(id).get();
	}

	// service method to delete data from Data Base
	public void delete(Long id) {

		repo.deleteById(id);

	}

}
