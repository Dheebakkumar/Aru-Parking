package com.parkingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.parkingProject.model.ParkingZone;

@Repository
public interface ParkingZoneRepo extends JpaRepository<ParkingZone, Long>{
	
	ParkingZone findById(long id);

}
