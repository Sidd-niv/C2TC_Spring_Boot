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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.placementManagementSystem.restFullAPIs.entities.Placement;
import com.tns.placementManagementSystem.restFullAPIs.services.ServicePlacement;

//This annotation will handle the get, post, put, delete request 
@RestController
public class PlacementController {

	// This annotation is used to inject dependences
	@Autowired(required=true)
	private ServicePlacement placementservice; // Instance variable

	// RESTful API methods to find specific placement data
	@GetMapping("/placements")
	public ResponseEntity<List<Placement>> list() {
		return ResponseEntity.status(HttpStatus.CREATED).body(placementservice.listAll());
	}

	// RESTful API methods to find specific student data
	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement> get(@PathVariable Long id) {
		try {
			Placement placement = placementservice.getplacementData(id);
			return new ResponseEntity<Placement>(placement, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API methods to find specific student data
	@PostMapping("/placement")
	public ResponseEntity<Placement> adddata(@RequestBody Placement placement) {
		try {
			placementservice.addplacementData(placement);
			return new ResponseEntity<Placement>(placement, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/placement/{id}")
	public ResponseEntity<Placement> deleteData(@PathVariable Long id) {
		placementservice.delete(id);
		return new ResponseEntity<Placement>(HttpStatus.OK);
	}

}
