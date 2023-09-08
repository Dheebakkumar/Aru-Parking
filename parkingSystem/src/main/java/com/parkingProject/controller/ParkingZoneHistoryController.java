package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingZoneHistoryDTO;
import com.parkingProject.service.ParkingZoneHistoryService;

@RestController
@RequestMapping("/parkingzone")
public class ParkingZoneHistoryController {
	
	@Autowired
	ParkingZoneHistoryService parkingZoneHistoryService;
	
	@GetMapping("/past/{id}")
	public List<ParkingZoneHistoryDTO> getZoneId(@PathVariable long id) {
		
		return parkingZoneHistoryService.getZoneId(id);
	}

	@GetMapping("/active/{id}")
	public List<ParkingZoneHistoryDTO> getActiveZoneId(@PathVariable long id) {
		
		return parkingZoneHistoryService.getActiveZoneId(id);
	}
}
