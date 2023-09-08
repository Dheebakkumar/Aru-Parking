package com.parkingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkingProject.model.ParkingSlots;
import com.parkingProject.model.ParkingZone;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlots, Long> {

	ParkingSlots findBySlotNameAndParkingZoneId(String slotName, long zoneId);

	ParkingSlots findById(long id);
	
	
}
