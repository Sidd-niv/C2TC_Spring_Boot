package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.placementManagementSystem.restFullAPIs.entities.College;
import com.tns.placementManagementSystem.restFullAPIs.entities.Student;
import com.tns.placementManagementSystem.restFullAPIs.services.ServiceCollege;

//This annotation will handle the get, post, put, delete request 
@RestController
public class CollegeController {

	// This annotation is used to inject dependences
	@Autowired(required=true)
	private ServiceCollege collegeservice; // Instance variable

	@GetMapping("/colleges")
	public ResponseEntity<List<College>> list() {
		return ResponseEntity.status(HttpStatus.CREATED).body(collegeservice.listAll());
	}

	// RESTful API methods to find specific student data
	@GetMapping("/college/{id}")
	public ResponseEntity<College> get(@PathVariable Long id) {
		try {
			College college = collegeservice.getcollegedata(id);
			return new ResponseEntity<College>(college, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API methods to find specific student data
	@PostMapping("/college")
	public ResponseEntity<College> adddata(@RequestBody College college) {
		try {
			collegeservice.save(college);
			return new ResponseEntity<College>(college, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
	
	// RESTful API method to update student data
		@PutMapping("/college/{id}")
		public ResponseEntity<College> update(@RequestBody College updateData, @PathVariable Long id) {
			try {
				College collegeData = collegeservice.getcollegedata(id);
				collegeservice.save(updateData);
				return new ResponseEntity<College>(HttpStatus.ACCEPTED);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
			}
		}

		// RESTful API method for Delete operation
		@DeleteMapping("/college/{id}")
		public ResponseEntity<College> deleteData(@PathVariable Long id) {
			collegeservice.delete(id);
			return new ResponseEntity<College>(HttpStatus.OK);
		}

	
	

}
