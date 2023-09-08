package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingZoneHistoryDTO;

public interface ParkingZoneHistoryService {
	
	List<ParkingZoneHistoryDTO> getZoneId(long id);
	
	List<ParkingZoneHistoryDTO> getActiveZoneId(long id);

}
