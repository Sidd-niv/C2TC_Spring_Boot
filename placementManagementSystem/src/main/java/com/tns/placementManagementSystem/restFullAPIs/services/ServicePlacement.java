package com.tns.placementManagementSystem.restFullAPIs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entities.Placement;
import com.tns.placementManagementSystem.restFullAPIs.repository.PlacementRepository;

//this annotation is for generic stereotype for any Spring-managed component.
@Component
public class ServicePlacement {

	// This annotation is used to inject dependences
	@Autowired(required=true)
	private PlacementRepository repo; // Instance variable

	// service method to find all data from Data Base
	public List<Placement> listAll() {
		return (List<Placement>) repo.findAll();
	}

	// service method to save data in Data Base
	public Placement addplacementData(Placement placement) {
		return repo.save(placement);
	}

	public Placement getplacementData(Long id) {
		return repo.getById(id);
	}

	// service method to delete data from Data Base
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

	

}
