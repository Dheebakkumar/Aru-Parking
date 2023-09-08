package com.parkingProject.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingProject.DTO.ParkingFeeDTO;
import com.parkingProject.DTO.ParkingSlotDTO;
import com.parkingProject.model.ParkingFee;
import com.parkingProject.model.ParkingSlots;
import com.parkingProject.repository.ParkingFeeRepo;
import com.parkingProject.service.ParkingFeeService;

@Service
public class ParkingFeeServiceImpl implements ParkingFeeService {

	@Autowired
	ParkingFeeRepo parkingFeeRepo;
	
	
	@Override
	public ParkingFeeDTO addFee(ParkingFeeDTO parkingFeeDto) {

			ParkingFee parkingFee = new ParkingFee();
			
			BigDecimal bigDecimal = new BigDecimal(parkingFeeDto.getTiming());
			
			BigDecimal perHour = new BigDecimal("10.00");
			BigDecimal totalAmount = bigDecimal.multiply(perHour);
			
			parkingFee.setTiming(parkingFeeDto.getTiming());
			parkingFee.setAmount(totalAmount);
			
			ParkingFee fee = parkingFeeRepo.save(parkingFee);
			return feeResponse(fee);
	}


	private ParkingFeeDTO feeResponse(ParkingFee fee) {
		
		ParkingFeeDTO dto = new ParkingFeeDTO();
		dto.setId(fee.getId());
		dto.setTiming(fee.getTiming());
		dto.setAmount(fee.getAmount());
		dto.setCreateOn(fee.getCreateOn());
		dto.setUpdateOn(fee.getUpdateOn());
		return dto;
	
	
	}


	@Override
	public List<ParkingFeeDTO> getAllFee() {
		

		List<ParkingFee> fee = parkingFeeRepo.findAll();
		List<ParkingFeeDTO> feeDto = new ArrayList();
		
		for (ParkingFee parking : fee) {
			
			ParkingFeeDTO dto = new ParkingFeeDTO();
			dto.setId(parking.getId());
			dto.setTiming(parking.getTiming());
			dto.setAmount(parking.getAmount());
			dto.setCreateOn(parking.getCreateOn());
			dto.setUpdateOn(parking.getUpdateOn());
			
			feeDto.add(dto);
		}
		
		return feeDto;
	}


	
	

}
