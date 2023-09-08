package com.parkingProject.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingProject.DTO.ParkingHistoryDTO;
import com.parkingProject.model.ParkingOrder;
import com.parkingProject.model.ParkingUser;
import com.parkingProject.repository.ParkingFeeRepo;
import com.parkingProject.repository.ParkingOrderRepo;
import com.parkingProject.repository.ParkingSlotRepo;
import com.parkingProject.repository.ParkingUserRepo;
import com.parkingProject.service.ParkingHistoryService;

@Service
public class ParkingHistoryServiceImpl implements ParkingHistoryService {

	@Autowired
	ParkingOrderRepo parkingOrderRepo;

	@Autowired
	ParkingUserRepo parkingUserRepo;
	
	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Autowired
	ParkingFeeRepo parkingFeeRepo;

	@Override
	public List<ParkingHistoryDTO> getIdUser(long id) {
		
		ParkingUser user = parkingUserRepo.findById(id);
		if(user !=null) {
			
//			SimpleDateFormat  current = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//			String t1 = current.format(timestamp);
			
			Date date = new Date();
			System.out.println(date );
			
			
			
			List<ParkingOrder> parkingOrderList = parkingOrderRepo.findAllByParkingUserId(id);
			List<ParkingHistoryDTO> userDto = new ArrayList();
			
			for (ParkingOrder parkingOrder : parkingOrderList) {
			
				int time = date.compareTo(parkingOrder.getParkingEndTime());
				
				if(time>0) {
					ParkingHistoryDTO dto = new ParkingHistoryDTO();
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
	public List<ParkingHistoryDTO> getActiveIdUser(long id) {
		
		
		ParkingUser user = parkingUserRepo.findById(id);
		if(user !=null) {
	
			Date date = new Date();
			System.out.println(date );
			
			
			
			List<ParkingOrder> parkingOrderList = parkingOrderRepo.findAllByParkingUserId(id);
			List<ParkingHistoryDTO> userDto = new ArrayList();
			
			for (ParkingOrder parkingOrder : parkingOrderList) {
			
				int time = date.compareTo(parkingOrder.getParkingEndTime());
				
				if(time<0) {
					
					ParkingHistoryDTO dto = new ParkingHistoryDTO();
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
