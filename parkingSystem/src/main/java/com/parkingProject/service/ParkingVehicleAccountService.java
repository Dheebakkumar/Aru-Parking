package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingVehicleAccountDTO;

public interface ParkingVehicleAccountService {
	
	public ParkingVehicleAccountDTO addAccount(ParkingVehicleAccountDTO parkingVehicleAccountDto);

	public ParkingVehicleAccountDTO updateAccount(ParkingVehicleAccountDTO parkingVehicleAccountDto);
	
	public Object deleteAccount(long id);
	
	public List<ParkingVehicleAccountDTO> getAll(long id);
	
	public ParkingVehicleAccountDTO getDefault(long id);

	public List<ParkingVehicleAccountDTO> getFavAll(long id);
	
	
}
