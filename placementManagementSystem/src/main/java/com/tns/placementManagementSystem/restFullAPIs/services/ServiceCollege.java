package com.tns.placementManagementSystem.restFullAPIs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entities.College;
import com.tns.placementManagementSystem.restFullAPIs.repository.CollegeRepository;

//this annotation is for generic stereotype for any Spring-managed component.
@Component
public class ServiceCollege {

	// This annotation is used to inject dependences
	@Autowired(required=true)
	private CollegeRepository repo; // Instance variable

	// service method to find all data from Data Base
	public List<College> listAll() {
		return repo.findAll();
	}

	// service method to find data by primary key from Data Base
	public College getcollegedata(Long id) {
		return repo.getById(id);
	}
    
	// service method to save data in Data Base
	public College save(College college) {
		return repo.save(college);
	}

	// service method to delete data from Data Base
	public void delete(Long id) {
		repo.deleteById(id);

	}

}
