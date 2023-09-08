package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingHistoryDTO;
import com.parkingProject.service.ParkingHistoryService;

@RestController
@RequestMapping("/history")
public class ParkingHistoryController {
	
	@Autowired 
	ParkingHistoryService parkingHistoryService;
	
	@GetMapping("/past/{id}")
	public List<ParkingHistoryDTO> getIdUser(@PathVariable long id) {
		
		return parkingHistoryService.getIdUser(id);
	
	}
	
	@GetMapping("/active/{id}")
	public List<ParkingHistoryDTO> getActiveIdUser(@PathVariable long id) {
		
		return parkingHistoryService.getActiveIdUser(id);
	}

}
