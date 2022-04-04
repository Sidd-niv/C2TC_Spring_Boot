package com.tns.placementManagementSystem.restFullAPIs.repository;

//Importing required package
import org.springframework.data.repository.CrudRepository;

import com.tns.placementManagementSystem.restFullAPIs.entities.Student;


//Declaring the interface to access  CURD methods
public interface StudentRepository extends CrudRepository<Student, Long> 

{


}