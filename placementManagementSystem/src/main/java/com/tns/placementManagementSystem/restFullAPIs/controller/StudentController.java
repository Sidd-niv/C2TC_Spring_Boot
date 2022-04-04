package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.placementManagementSystem.restFullAPIs.entities.Student;
import com.tns.placementManagementSystem.restFullAPIs.services.ServiceCertificate;
import com.tns.placementManagementSystem.restFullAPIs.services.ServiceStudent;

//This annotation will handle the get, post, put, delete request 
@RestController
public class StudentController {

	// This annotation is used to inject dependences
	@Autowired(required=true)
	private ServiceStudent studentservice; // Instance variable

	@Autowired(required=true)
	private ServiceCertificate certificateservice; // Instance variable

	// RESTful API methods to all student data
	@GetMapping("/students")
	public ResponseEntity<List<Student>> list() {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentservice.listAll());
	}

	// RESTful API methods to find specific student data
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> get(@PathVariable Long id) {
		try {
			Student student = studentservice.getstudent(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API methods to find specific student data
	@PostMapping("/student")
	public ResponseEntity<Student> adddata(@RequestBody Student student) {
		try {
			studentservice.save(student);
			certificateservice.save(student.getCertificate());
			return new ResponseEntity<Student>(student, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method to update student data
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> update(@RequestBody Student updateData, @PathVariable Long id) {
		try {
			Student studentData = studentservice.getstudent(id);
			studentservice.save(updateData);
			return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteData(@PathVariable Long id) {
		studentservice.delete(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}
