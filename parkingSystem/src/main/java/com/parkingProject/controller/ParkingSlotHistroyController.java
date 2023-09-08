package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingSlotHistoryDTO;
import com.parkingProject.service.ParkingSlotHistoryService;

@RestController
@RequestMapping("/parkingslot")
public class ParkingSlotHistroyController {
	
	@Autowired
	ParkingSlotHistoryService parkingSlotHistoryService;
	
	
	@GetMapping("/past/{id}")
	public List<ParkingSlotHistoryDTO> getSlotId(@PathVariable long id){
		
		
		return parkingSlotHistoryService.getSlotId(id) ;
		
	}

	@GetMapping("/active/{id}")
	public List<ParkingSlotHistoryDTO> getSlotActiveId(@PathVariable long id){
		
		
		return parkingSlotHistoryService.getSlotActiveId(id);
		
	}
	
}
