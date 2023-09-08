package com.parkingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingOrderDTO;
import com.parkingProject.service.ParkingOrderService;

@RestController
@RequestMapping("/order")
public class ParkingOderController {
	
	@Autowired
	ParkingOrderService parkingOrderService;
	
	
	@PostMapping("/add")
	public ParkingOrderDTO addOrder(@RequestBody ParkingOrderDTO parkingOrderDTO) {
		System.out.println("order CONTROLLER");
		return parkingOrderService.addOrder(parkingOrderDTO);
		
	}

}
