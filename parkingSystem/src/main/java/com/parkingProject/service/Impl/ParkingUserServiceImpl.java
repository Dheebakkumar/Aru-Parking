package com.parkingProject.service.Impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingProject.DTO.ParkingUserDTO;
import com.parkingProject.model.ParkingUser;

import com.parkingProject.repository.ParkingUserRepo;
import com.parkingProject.service.ParkingUserService;

@Service
public class ParkingUserServiceImpl implements ParkingUserService {

	@Autowired
	ParkingUserRepo parkingUserRepo;

	@Override
	public ParkingUserDTO addUser(ParkingUserDTO userDTO) {
		
		ParkingUser parkingUser = new ParkingUser();
		parkingUser.setFirstName(userDTO.getFirstName());
		parkingUser.setLastName(userDTO.getLastName());
		parkingUser.setEmailId(userDTO .getEmailId());
		parkingUser.setDob(userDTO.getDob());
		parkingUser.setBalance(new BigDecimal("100.00"));
		
		ParkingUser saveUser = parkingUserRepo.save(parkingUser);
		
		ParkingUserDTO dto = new ParkingUserDTO();
		dto.setId(saveUser.getId());
		dto.setFirstName(saveUser.getFirstName());
		dto.setLastName(saveUser.getLastName());
		dto.setEmailId(saveUser.getEmailId());
		dto.setDob(saveUser.getDob());
		dto.setBalance(saveUser.getBalance());
		dto.setCreateOn(saveUser.getCreateOn());
		dto.setUpdateOn(saveUser.getUpdateOn());
		
		return dto;
		
	}
}
