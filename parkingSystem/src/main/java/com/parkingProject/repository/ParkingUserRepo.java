package com.parkingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.parkingProject.model.ParkingUser;

@Repository
public interface ParkingUserRepo extends JpaRepository<ParkingUser, Long> {
	
	ParkingUser findById(long id);
}
