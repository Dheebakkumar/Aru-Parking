package com.parkingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingUserDTO;
import com.parkingProject.service.ParkingUserService;

@RestController
@RequestMapping("/user")
public class ParkingUserController {
	
	@Autowired
	ParkingUserService parkingUserService;
	
	@PostMapping("/add")
	public ParkingUserDTO addUser(@RequestBody ParkingUserDTO parkingUserDto) {
		
		return parkingUserService.addUser(parkingUserDto);
		
	}

}
