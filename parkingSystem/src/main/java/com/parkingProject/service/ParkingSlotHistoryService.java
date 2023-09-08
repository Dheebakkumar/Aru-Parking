package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingSlotHistoryDTO;

public interface ParkingSlotHistoryService {
	
	List<ParkingSlotHistoryDTO> getSlotId(long id); 
	
	List<ParkingSlotHistoryDTO> getSlotActiveId(long id); 


}
