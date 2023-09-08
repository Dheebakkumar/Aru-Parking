package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingFeeDTO;
import com.parkingProject.service.ParkingFeeService;

@RestController
@RequestMapping("/fee")
public class ParkingFeeController {
	
	@Autowired
	ParkingFeeService parkingFeeService;
	
	
	@PostMapping("/add")
	public ParkingFeeDTO addFee(@RequestBody ParkingFeeDTO parkingFeeDTO) {
		
		System.out.println("this is person 1");
		return parkingFeeService.addFee(parkingFeeDTO);
		
	}
	
	@GetMapping("/all")
	public List<ParkingFeeDTO> getAllFee(){
		
		return parkingFeeService.getAllFee();
		
	}

}
