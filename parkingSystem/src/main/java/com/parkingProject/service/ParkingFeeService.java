package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingFeeDTO;

public interface ParkingFeeService {
	
	public ParkingFeeDTO addFee(ParkingFeeDTO parkingFeeDto);
	
	List<ParkingFeeDTO> getAllFee();

}
