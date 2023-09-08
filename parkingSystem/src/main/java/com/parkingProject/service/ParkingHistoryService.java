package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingHistoryDTO;
import com.parkingProject.model.ParkingUser;

public interface ParkingHistoryService {
	
	public List<ParkingHistoryDTO> getIdUser(long id);
	
	public List<ParkingHistoryDTO> getActiveIdUser(long id);

}
