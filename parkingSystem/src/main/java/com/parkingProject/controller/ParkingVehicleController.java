package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingVehicleAccountDTO;
import com.parkingProject.service.ParkingVehicleAccountService;

@RestController
@RequestMapping("/vehicle")
public class ParkingVehicleController {
	
	@Autowired
	ParkingVehicleAccountService parkingVehicleService;
	
	
	@PostMapping("/add")
	public ParkingVehicleAccountDTO addAccount(@RequestBody ParkingVehicleAccountDTO parkingVehicleAccountDto) {
		System.out.println("This is Vehicle Account");
		return parkingVehicleService.addAccount(parkingVehicleAccountDto);
		
	}
	
	@PutMapping("/update")
	public ParkingVehicleAccountDTO updateAccount(@RequestBody ParkingVehicleAccountDTO parkingVehicleAccountDto) {
		
		return parkingVehicleService.updateAccount(parkingVehicleAccountDto);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Object deleteAccount(@PathVariable long id) {
		
		return parkingVehicleService.deleteAccount(id);
		
	}
	
	@GetMapping("/all/{id}")
	public List<ParkingVehicleAccountDTO> getAll(@PathVariable long id){
		
		return parkingVehicleService.getAll(id);
		
	}
	
	@GetMapping("/alldefault/{id}")
	public ParkingVehicleAccountDTO getDefault(@PathVariable long id){
		
		return parkingVehicleService.getDefault(id);
		
	}
	
	@GetMapping("/allfav/{id}")
	public List<ParkingVehicleAccountDTO> getFavAll(@PathVariable long id){
		
		return parkingVehicleService.getFavAll(id);
		
	}
}
