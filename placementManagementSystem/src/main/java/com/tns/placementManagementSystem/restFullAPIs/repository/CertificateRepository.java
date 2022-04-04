package com.tns.placementManagementSystem.restFullAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.placementManagementSystem.restFullAPIs.entities.Certificate;




//Declaring the interface to access  CURD methods
public interface CertificateRepository extends JpaRepository<Certificate, Long> 

{


}
