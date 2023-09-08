package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingSlotDTO;

public interface ParkingSlotService {
	
	public Object addSlots(ParkingSlotDTO parkingSlotDto) ;
	public ParkingSlotDTO getBySlot(long id);
	public List<ParkingSlotDTO>  getAllSlots();
	public ParkingSlotDTO updateSlot(ParkingSlotDTO parkingSlotDto) ;
	

}
