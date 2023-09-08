package com.parkingProject.service.Impl;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingProject.DTO.ParkingOrderDTO;
import com.parkingProject.model.ParkingFee;
import com.parkingProject.model.ParkingOrder;
import com.parkingProject.model.ParkingSlots;
import com.parkingProject.model.ParkingUser;
import com.parkingProject.repository.ParkingFeeRepo;
import com.parkingProject.repository.ParkingOrderRepo;
import com.parkingProject.repository.ParkingSlotRepo;
import com.parkingProject.repository.ParkingUserRepo;
import com.parkingProject.service.ParkingOrderService;

@Service
public class ParkingOrderServiceImpl implements ParkingOrderService {
	
	@Autowired
	ParkingOrderRepo parkingOrderRepo;

	@Autowired
	ParkingUserRepo parkingUserRepo;
	
	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Autowired
	ParkingFeeRepo parkingFeeRepo;
	
	@Override
	public ParkingOrderDTO addOrder(ParkingOrderDTO parkingOrderDto) {
	
		ParkingUser parkingUser = parkingUserRepo.findById(parkingOrderDto.getUserId());
		
		if(parkingUser !=null) {
			
			ParkingSlots parkingSlot = parkingSlotRepo.findById(parkingOrderDto.getSlotId());
			
			if(parkingSlot !=null) {
				
				ParkingFee parkingFee = parkingFeeRepo.findById(parkingOrderDto.getFeeId());
				
				if(parkingFee !=null) {
					
					ParkingOrder parkingOrder = new ParkingOrder();
					
					BigDecimal totalAmount = parkingFee.getAmount();
					System.out.println(totalAmount);
					
					BigDecimal balanceAmount = parkingUser.getBalance();
					System.out.println(balanceAmount);
					
					int value = totalAmount.compareTo(balanceAmount);
					System.out.println(value);
					
					if(value <=0 ) {
						
						BigDecimal currentBalance = balanceAmount.subtract(totalAmount);
						System.out.println(currentBalance);
				
						
						parkingUser.setBalance(currentBalance);
						
						parkingUserRepo.save(parkingUser);
						
						
						Date date = new Date();
						Date  time = DateUtils.addHours(date, Integer.parseInt(parkingFee.getTiming()));
						
						parkingOrder.setParkingEndTime(time);
						parkingOrder.setParkingUser(parkingUser);
						parkingOrder.setParkingSlot(parkingSlot);
						parkingOrder.setParkingFee(parkingFee);
						parkingOrder.setDescription("Payment Successful");
						parkingOrder.setTransactionId(UUID.randomUUID().toString());
						parkingOrder.setAmount(parkingFee.getAmount());
						parkingOrder.setVehicleNo(parkingOrderDto.getVehicleNo());
						parkingOrder.setContactNo(parkingOrderDto.getContactNo());
						
						ParkingOrder order = parkingOrderRepo.save(parkingOrder);
						
						ParkingOrderDTO dto = new ParkingOrderDTO();
						
						dto.setDescription(order.getDescription());
						dto.setAmount(order.getAmount());
						dto.setId(order.getId());
						dto.setTransactionId(order.getTransactionId());
						dto.setVehicleNo(order.getVehicleNo());
						dto.setContactNo(order.getContactNo());
						return dto;
						
					}
					else {
						throw new RuntimeException("Your Balance is LessThan Amount...");
					}
					
					
				}
				else {
					throw new RuntimeException("Fee Id not Present...");
				}
			}
			else {
				throw new RuntimeException("Solt Id not Present...");
			}
			
		}
		else {
			throw new RuntimeException("User Id not Present...");
		}

		
	}

}
