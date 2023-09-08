package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingSlotDTO;
import com.parkingProject.service.ParkingSlotService;

@RestController
@RequestMapping("/parking")
public class ParkingSlotController {

	@Autowired
	ParkingSlotService parkingSlotService;
	
	@PostMapping("/slots")
	public Object addSlots(@RequestBody ParkingSlotDTO parkingSlotDto) {
		
		System.out.println("this is ParkingSlot");
		return parkingSlotService.addSlots(parkingSlotDto);
		
	}
	
	@GetMapping("/{id}")
	public ParkingSlotDTO getBySlot(@PathVariable Long id) {
		
		return parkingSlotService.getBySlot(id);
		
	}
	
	@GetMapping("/all")
	public List<ParkingSlotDTO> getAllSlots(){
		
		return parkingSlotService.getAllSlots();
		
	}
	
	@PutMapping("/update")
	public ParkingSlotDTO updateSlot(@RequestBody ParkingSlotDTO parkingSlotDto) {
		
		return parkingSlotService.updateSlot(parkingSlotDto);
		
	}
}
