package com.parkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parkingProject.DTO.ParkingZoneDTO;
import com.parkingProject.service.ParkingZoneService;

@RestController
@RequestMapping("/zones")
public class ParkingZoneController {

	@Autowired
	ParkingZoneService parkingZoneService;

	@GetMapping("/{id}")
	public ParkingZoneDTO getUserDetails(@PathVariable long id) {
		  System.out.println("this is Zone id");
		return parkingZoneService.getUserDetails(id);

	}

//	@RequestMapping(value="new", method=RequestMethod.POST)
	@PostMapping("/new")
	public ParkingZoneDTO addZones(@RequestBody ParkingZoneDTO parkingZoneDTO) {

		return parkingZoneService.addZones(parkingZoneDTO);
	}

	@GetMapping("/parkingZones")
	public List<ParkingZoneDTO> getZones() {

		return parkingZoneService.getZones();

	}

	@PutMapping("/update")
	public ParkingZoneDTO updateZone(@RequestBody ParkingZoneDTO parkingZoneDTO) {

		return parkingZoneService.updateZone(parkingZoneDTO);

	}
	

}
