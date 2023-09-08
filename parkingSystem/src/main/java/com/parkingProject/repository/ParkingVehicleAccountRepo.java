package com.parkingProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkingProject.model.ParkingVehicleAccount;

@Repository
public interface ParkingVehicleAccountRepo extends JpaRepository<ParkingVehicleAccount, Long>{


	List<ParkingVehicleAccount> findByDefaultVehicle(boolean defaultVehicle);
	
	ParkingVehicleAccount findByParkingUserIdAndDefaultVehicle(long userId, boolean defaultVehicle);


	ParkingVehicleAccount findByParkingUserIdAndVehicleNo(long userId, String vehicleNo);

	ParkingVehicleAccount findById(long id);
	
	List<ParkingVehicleAccount> findByFavVehicle(boolean favVehicle);

	List<ParkingVehicleAccount> findByParkingUserId(long id);

	List<ParkingVehicleAccount> findByParkingUserIdAndFavVehicle(long id, boolean b);

	
	
	
}
