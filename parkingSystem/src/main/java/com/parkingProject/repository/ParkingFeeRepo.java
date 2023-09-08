package com.parkingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkingProject.model.ParkingFee;

@Repository
public interface ParkingFeeRepo extends JpaRepository<ParkingFee, Long> {
	
	ParkingFee findById(long id);

}
