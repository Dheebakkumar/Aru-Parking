package com.parkingProject.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingProject.DTO.ParkingSlotHistoryDTO;
import com.parkingProject.DTO.ParkingZoneHistoryDTO;
import com.parkingProject.model.ParkingOrder;
import com.parkingProject.model.ParkingSlots;
import com.parkingProject.repository.ParkingFeeRepo;
import com.parkingProject.repository.ParkingOrderRepo;
import com.parkingProject.repository.ParkingSlotRepo;
import com.parkingProject.repository.ParkingUserRepo;
import com.parkingProject.repository.ParkingZoneRepo;
import com.parkingProject.service.ParkingSlotHistoryService;

@Service
public class ParkingSlotHistoryServiceImpl implements ParkingSlotHistoryService{
	
	@Autowired
	ParkingZoneRepo userRepo;
	
	@Autowired
	ParkingOrderRepo parkingOrderRepo;

	@Autowired
	ParkingUserRepo parkingUserRepo;
	
	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Autowired
	ParkingFeeRepo parkingFeeRepo;

	@Override
	public List<ParkingSlotHistoryDTO> getSlotId(long id) {
		
		ParkingSlots slot = parkingSlotRepo.findById(id);
		
		if(slot !=null) {
			
			Date date = new Date();
			System.out.println(date );
			
			List<ParkingOrder> parkingOrderList = parkingOrderRepo.findAllByParkingSlotId(id);
			List<ParkingSlotHistoryDTO> userDto = new ArrayList();
			
			for (ParkingOrder parkingOrder : parkingOrderList) {
				
				int time = date.compareTo(parkingOrder.getParkingEndTime());
				
				if(time>0) {
					
					ParkingSlotHistoryDTO dto = new ParkingSlotHistoryDTO();
					dto.setUserId(parkingOrder.getParkingUser().getId());
					dto.setSlotId(parkingOrder.getParkingSlot().getId());
					dto.setZoneId(parkingOrder.getParkingSlot().getParkingZone().getId());
					dto.setOrderId(parkingOrder.getId());
					dto.setParkingStartTime(parkingOrder.getParkingStartTime());
					dto.setParkingEndTime(parkingOrder.getParkingEndTime());
					dto.setPayee("Aru Parking");
					dto.setVehicleNo(parkingOrder.getVehicleNo());
					dto.setSlotName(parkingOrder.getParkingSlot().getSlotName());
					dto.setFeeId(parkingOrder.getId());
					dto.setAmount(parkingOrder.getAmount());
					dto.setTransactionId(parkingOrder.getTransactionId());
				
					userDto.add(dto);

				}
				 
			}			
			return userDto;
		}
		return null;
	}

	@Override
	public List<ParkingSlotHistoryDTO> getSlotActiveId(long id) {

		ParkingSlots slot = parkingSlotRepo.findById(id);
		
		if(slot !=null) {
			
			Date date = new Date();
			System.out.println(date );
			
			List<ParkingOrder> parkingOrderList = parkingOrderRepo.findAllByParkingSlotId(id);
			List<ParkingSlotHistoryDTO> userDto = new ArrayList();
			
			for (ParkingOrder parkingOrder : parkingOrderList) {
				
				int time = date.compareTo(parkingOrder.getParkingEndTime());
				
				if(time<0) {
					
					ParkingSlotHistoryDTO dto = new ParkingSlotHistoryDTO();
					dto.setUserId(parkingOrder.getParkingUser().getId());
					dto.setSlotId(parkingOrder.getParkingSlot().getId());
					dto.setZoneId(parkingOrder.getParkingSlot().getParkingZone().getId());
					dto.setOrderId(parkingOrder.getId());
					dto.setParkingStartTime(parkingOrder.getParkingStartTime());
					dto.setParkingEndTime(parkingOrder.getParkingEndTime());
					dto.setPayee("Aru Parking");
					dto.setVehicleNo(parkingOrder.getVehicleNo());
					dto.setSlotName(parkingOrder.getParkingSlot().getSlotName());
					dto.setFeeId(parkingOrder.getId());
					dto.setAmount(parkingOrder.getAmount());
					dto.setTransactionId(parkingOrder.getTransactionId());
				
				
					userDto.add(dto);

				}
				
			}			
			return userDto;
		}
		
		return null;
	}

}
