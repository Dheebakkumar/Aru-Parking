package com.parkingProject.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkingProject.DTO.ParkingZoneHistoryDTO;
import com.parkingProject.model.ParkingOrder;
import com.parkingProject.model.ParkingZone;
import com.parkingProject.repository.ParkingFeeRepo;
import com.parkingProject.repository.ParkingOrderRepo;
import com.parkingProject.repository.ParkingSlotRepo;
import com.parkingProject.repository.ParkingUserRepo;
import com.parkingProject.repository.ParkingZoneRepo;
import com.parkingProject.service.ParkingZoneHistoryService;

@Service
public class ParkingZoneHistoryServiceImpl implements ParkingZoneHistoryService{

	@Autowired
	ParkingZoneRepo parkingZoneRepo;
	
	@Autowired
	ParkingOrderRepo parkingOrderRepo;

	@Autowired
	ParkingUserRepo parkingUserRepo;
	
	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Autowired
	ParkingFeeRepo parkingFeeRepo;


	@Override
	public List<ParkingZoneHistoryDTO> getZoneId(long id) {

		ParkingZone parkingZone = parkingZoneRepo.findById(id);
		
		if(parkingZone !=null) {
			
			Date date = new Date();
			System.out.println(date );
			
			List<ParkingOrder> parkingOrderList = parkingOrderRepo.findAllByParkingSlotParkingZoneId(id);
			List<ParkingZoneHistoryDTO> zoneHistoryDto = new ArrayList();
			
			for (ParkingOrder parkingOrder : parkingOrderList) {
				
				int time = date.compareTo(parkingOrder.getParkingEndTime());
				
				if(time>0) {
					
					ParkingZoneHistoryDTO dto = new ParkingZoneHistoryDTO();
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
				
					zoneHistoryDto.add(dto);

				}
				
			}			
			return zoneHistoryDto;
		
		}
		return null;
	}


	@Override
	public List<ParkingZoneHistoryDTO> getActiveZoneId(long id) {

		ParkingZone parkingZones = parkingZoneRepo.findById(id);
		
		if(parkingZones !=null) {
			
			Date date = new Date();
			System.out.println(date );
			
			List<ParkingOrder> parkingOrderList = parkingOrderRepo.findAllByParkingSlotParkingZoneId(id);
			List<ParkingZoneHistoryDTO> zoneHistoryDto = new ArrayList();
			
			for (ParkingOrder parkingOrder : parkingOrderList) {
				
				int time = date.compareTo(parkingOrder.getParkingEndTime());
				
				if(time<0) {
					
					ParkingZoneHistoryDTO dto = new ParkingZoneHistoryDTO();
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
				
					zoneHistoryDto.add(dto);

				}
				
			}			
			return zoneHistoryDto;
		
		}
		return null;
		
	}
	
	
	}
	
	
