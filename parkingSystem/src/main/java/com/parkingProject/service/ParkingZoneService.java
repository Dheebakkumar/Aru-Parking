package com.parkingProject.service;

import java.util.List;

import com.parkingProject.DTO.ParkingZoneDTO;


public interface ParkingZoneService  {

	public ParkingZoneDTO getUserDetails(long id);
	public ParkingZoneDTO addZones(ParkingZoneDTO parkingZoneDTO);
	public List<ParkingZoneDTO> getZones(); 
	public ParkingZoneDTO updateZone (ParkingZoneDTO parkingZoneDTO);
	
	
}
