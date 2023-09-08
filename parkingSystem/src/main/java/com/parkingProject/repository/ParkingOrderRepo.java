package com.parkingProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.parkingProject.model.ParkingOrder;
import com.parkingProject.model.ParkingUser;

@Repository
public interface ParkingOrderRepo extends JpaRepository<ParkingOrder, Long> {
	
	ParkingOrder findById(long id);

	List<ParkingOrder> findAllByParkingUserId(long id);

	List<ParkingOrder> findAllByParkingSlotParkingZoneId(long id);

	List<ParkingOrder> findAllByParkingSlotId(long id);

}
