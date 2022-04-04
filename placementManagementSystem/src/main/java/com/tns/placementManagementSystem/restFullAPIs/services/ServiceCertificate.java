package com.tns.placementManagementSystem.restFullAPIs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entities.Certificate;
import com.tns.placementManagementSystem.restFullAPIs.repository.CertificateRepository;


@Component
public class ServiceCertificate {

	@Autowired(required=true)
	private CertificateRepository repo;

	// service method to find all data from Data Base
	public List<Certificate> listAll() {
		return (List<Certificate>) repo.findAll();

	}

	// service method to save data in Data Base
	public void save(Certificate certificate) {
		repo.save(certificate);
	}

	// service method to find data by primary key from Data Base
	public Certificate getcertificate(Long id) {

		return repo.findById(id).get();
	}

	// service method to delete data from Data Base
	public void delete(Long id) {

		repo.deleteById(id);

	}

}
