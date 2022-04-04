package com.tns.placementManagementSystem.restFullAPIs.repository;

//Importing required package
import org.springframework.data.jpa.repository.*;

import com.tns.placementManagementSystem.restFullAPIs.entities.Placement;


//Declaring the interface to access  CURD methods
public interface PlacementRepository extends JpaRepository<Placement, Long> 

{


}
