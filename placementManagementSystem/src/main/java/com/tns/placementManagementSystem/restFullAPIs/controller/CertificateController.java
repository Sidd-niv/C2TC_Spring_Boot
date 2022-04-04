package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.placementManagementSystem.restFullAPIs.entities.Certificate;
import com.tns.placementManagementSystem.restFullAPIs.services.ServiceCertificate;

//This annotation will handle the get, post, put, delete request 
@RestController
public class CertificateController {

	@Autowired(required=true)
	private ServiceCertificate certificateservice; // Instance variable

	@GetMapping("/certificates")
	public ResponseEntity<List<Certificate>> list() {
		return ResponseEntity.status(HttpStatus.CREATED).body(certificateservice.listAll());
	}

	// RESTful API method to update student data
	@PutMapping("/certificate/{id}")
	public ResponseEntity<Certificate> update(@RequestBody Certificate updateData, @PathVariable Long id) {
		try {
			Certificate certificateData = certificateservice.getcertificate(id);
			certificateservice.save(updateData);
			return new ResponseEntity<Certificate>(HttpStatus.ACCEPTED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/certificate/{id}")
	public ResponseEntity<Certificate> deleteData(@PathVariable Long id) {
		 certificateservice.delete(id);
		return new ResponseEntity<Certificate>(HttpStatus.OK);
	}

}
