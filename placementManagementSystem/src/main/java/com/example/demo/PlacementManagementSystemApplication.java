package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tns.placementManagementSystem.restFullAPIs.repository.CertificateRepository;
import com.tns.placementManagementSystem.restFullAPIs.repository.CollegeRepository;
import com.tns.placementManagementSystem.restFullAPIs.repository.StudentRepository;
import com.tns.placementManagementSystem.restFullAPIs.repository.UserRepository;

@SpringBootApplication
public class PlacementManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PlacementManagementSystemApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		CollegeRepository collegeRepository = context.getBean(CollegeRepository.class);
		CertificateRepository certificateRepository = context.getBean(CertificateRepository.class);
		UserRepository userRepository =context.getBean(UserRepository.class);
	}

}
