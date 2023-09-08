package com.parkingProject.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkingProject.DTO.ParkingVehicleAccountDTO;
import com.parkingProject.model.ParkingUser;
import com.parkingProject.model.ParkingVehicleAccount;
import com.parkingProject.repository.ParkingUserRepo;
import com.parkingProject.repository.ParkingVehicleAccountRepo;
import com.parkingProject.service.ParkingVehicleAccountService;

@Service("parkingVehicleService")
public class ParkingVehicleAccountServiceImpl implements ParkingVehicleAccountService {

	@Autowired
	ParkingVehicleAccountRepo parkingVehicleAccountRepo;
	
	@Autowired
	ParkingUserRepo parkingUserRepo;

	
	
	
	@Override
	public ParkingVehicleAccountDTO addAccount(ParkingVehicleAccountDTO parkingVehicleAccountDto) {

		
		ParkingUser parkingUser = parkingUserRepo.findById(parkingVehicleAccountDto.getUserId());
		
		if(parkingUser !=null) {
			
			ParkingVehicleAccount parkingVehicleAccount = parkingVehicleAccountRepo.findByParkingUserIdAndVehicleNo(parkingVehicleAccountDto.getUserId() ,parkingVehicleAccountDto.getVehicleNo());
			
			if(parkingVehicleAccount==null) {
								
					ParkingVehicleAccount parkingVehicleAccount2 = new ParkingVehicleAccount();
					
					parkingVehicleAccount2.setParkingUser(parkingUser);
					parkingVehicleAccount2.setVehicleNo(parkingVehicleAccountDto.getVehicleNo());
					parkingVehicleAccount2.setVehicleName(parkingVehicleAccountDto.getVehicleName());
					parkingVehicleAccount2.setDefaultVehicle(parkingVehicleAccountDto.isDefaultVehicle());
					parkingVehicleAccount2.setStatus(1);
					parkingVehicleAccount2.setFavVehicle(parkingVehicleAccountDto.isFavVehicle());
					
					
					
					if(parkingVehicleAccountDto.isDefaultVehicle()==true) {
						
						ParkingVehicleAccount list = parkingVehicleAccountRepo.findByParkingUserIdAndDefaultVehicle(parkingVehicleAccountDto.getUserId() ,parkingVehicleAccountDto.isDefaultVehicle()) ;						
						
						if(list == null) {
							
							ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.save(parkingVehicleAccount2);
							
							ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
							dto.setId(vehicle.getId());
							dto.setUserId(vehicle.getParkingUser().getId());
							dto.setVehicleNo(vehicle.getVehicleNo());
							dto.setVehicleName(vehicle.getVehicleName());
							dto.setDefaultVehicle(vehicle.isDefaultVehicle());
							dto.setStatus(vehicle.getStatus());
							dto.setFavVehicle(vehicle.isFavVehicle());
							dto.setCreatedOn(vehicle.getCreatedOn());
							dto.setUpdatedOn(vehicle.getUpdatedOn());
							
							
							return dto;
							
						
						}
						else {
							
							list.setDefaultVehicle(false);
							parkingVehicleAccountRepo.save(list);
							
							ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.save(parkingVehicleAccount2);
							
							ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
							dto.setId(vehicle.getId());
							dto.setUserId(vehicle.getParkingUser().getId());
							dto.setVehicleNo(vehicle.getVehicleNo());
							dto.setVehicleName(vehicle.getVehicleName());
							dto.setDefaultVehicle(vehicle.isDefaultVehicle());
							dto.setStatus(vehicle.getStatus());
							dto.setFavVehicle(vehicle.isFavVehicle());
							dto.setCreatedOn(vehicle.getCreatedOn());
							dto.setUpdatedOn(vehicle.getUpdatedOn());
							
							
							return dto;
						}
						
					}
					else {
						
						ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.save(parkingVehicleAccount2);

						ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
						dto.setId(vehicle.getId());
						dto.setUserId(vehicle.getParkingUser().getId());
						dto.setVehicleNo(vehicle.getVehicleNo());
						dto.setVehicleName(vehicle.getVehicleName());
						dto.setDefaultVehicle(vehicle.isDefaultVehicle());
						dto.setStatus(vehicle.getStatus());
						dto.setFavVehicle(vehicle.isFavVehicle());
						dto.setCreatedOn(vehicle.getCreatedOn());
						dto.setUpdatedOn(vehicle.getUpdatedOn());
						
						
						return dto;
					}
			}
			else {
				
				throw new RuntimeException("vehicle Number is unique for each user vehicle");
			}
			
		}
		else {
			
			throw new RuntimeException("User Id is Not Present");
		}
		
	}




	@Override
	public ParkingVehicleAccountDTO updateAccount(ParkingVehicleAccountDTO parkingVehicleAccountDto) {

		ParkingVehicleAccount parking = parkingVehicleAccountRepo.findById(parkingVehicleAccountDto.getId());
		
		if(parking !=null) {
			
			ParkingVehicleAccount parkingVehicleAccount = parkingVehicleAccountRepo.findByParkingUserIdAndVehicleNo(parkingVehicleAccountDto.getUserId() ,parkingVehicleAccountDto.getVehicleNo());
			
			if(parkingVehicleAccount==null) {
					
				
				parking.setVehicleNo(parkingVehicleAccountDto.getVehicleNo());
				parking.setVehicleName(parkingVehicleAccountDto.getVehicleName());
				parking.setDefaultVehicle(parkingVehicleAccountDto.isDefaultVehicle());
				parking.setFavVehicle(parkingVehicleAccountDto.isFavVehicle());
					
					if(parkingVehicleAccountDto.isDefaultVehicle()==true) {
						
						ParkingVehicleAccount list = parkingVehicleAccountRepo.findByParkingUserIdAndDefaultVehicle(parkingVehicleAccountDto.getUserId() ,parkingVehicleAccountDto.isDefaultVehicle()) ;						
						
						if(list == null) {
							
							ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.save(parking);
							
							ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
							dto.setId(vehicle.getId());
							dto.setUserId(vehicle.getParkingUser().getId());
							dto.setVehicleNo(vehicle.getVehicleNo());
							dto.setVehicleName(vehicle.getVehicleName());
							dto.setDefaultVehicle(vehicle.isDefaultVehicle());
							dto.setStatus(vehicle.getStatus());
							dto.setFavVehicle(vehicle.isFavVehicle());
							dto.setCreatedOn(vehicle.getCreatedOn());
							dto.setUpdatedOn(vehicle.getUpdatedOn());
							
							
							return dto;
							
						
						}
						else {
							
							list.setDefaultVehicle(false);
							parkingVehicleAccountRepo.save(list);
							
							ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.save(parking);
							
							ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
							dto.setId(vehicle.getId());
							dto.setUserId(vehicle.getParkingUser().getId());
							dto.setVehicleNo(vehicle.getVehicleNo());
							dto.setVehicleName(vehicle.getVehicleName());
							dto.setDefaultVehicle(vehicle.isDefaultVehicle());
							dto.setStatus(vehicle.getStatus());
							dto.setFavVehicle(vehicle.isFavVehicle());
							dto.setCreatedOn(vehicle.getCreatedOn());
							dto.setUpdatedOn(vehicle.getUpdatedOn());
							
							
							return dto;
						}
						
					}
					else {
						
						ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.save(parking);

						ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
						dto.setId(vehicle.getId());
						dto.setUserId(vehicle.getParkingUser().getId());
						dto.setVehicleNo(vehicle.getVehicleNo());
						dto.setVehicleName(vehicle.getVehicleName());
						dto.setDefaultVehicle(vehicle.isDefaultVehicle());
						dto.setStatus(vehicle.getStatus());
						dto.setFavVehicle(vehicle.isFavVehicle());
						dto.setCreatedOn(vehicle.getCreatedOn());
						dto.setUpdatedOn(vehicle.getUpdatedOn());
						
						
						return dto;
					}
			}
			else {
				
				throw new RuntimeException("vehicle Number is Already Present in this User");
			}
			
		}
		else {
			
			throw new RuntimeException("Vehicle Id is Not Present");
		}

	}




	@Override
	public Object deleteAccount(long id) {

		ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.findById(id);
		
		if(vehicle !=null) {
			
			vehicle.setStatus(0);
			parkingVehicleAccountRepo.save(vehicle);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", "Deleted Successfully");
			return map;
		}
		else {
			
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", "Account does not exist");
			return map;
		}
		
		
		
	}



	@Override
	public List<ParkingVehicleAccountDTO> getAll(long id) {
		
		ParkingUser parkingUser = parkingUserRepo.findById(id);
		
		if(parkingUser !=null) {
			
			List<ParkingVehicleAccount> vehicleList = parkingVehicleAccountRepo.findByParkingUserId(id);
			
			List<ParkingVehicleAccountDTO> vehicleDto = new  ArrayList<ParkingVehicleAccountDTO>();
			
			for (ParkingVehicleAccount vehicle : vehicleList) {
				
				ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
				dto.setId(vehicle.getId());
				dto.setUserId(vehicle.getParkingUser().getId());
				dto.setVehicleName(vehicle.getVehicleName());
				dto.setVehicleNo(vehicle.getVehicleNo());
				dto.setStatus(vehicle.getStatus());
				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setFavVehicle(vehicle.isFavVehicle());
				dto.setCreatedOn(vehicle.getCreatedOn());
				dto.setUpdatedOn(vehicle.getUpdatedOn());
				
				vehicleDto.add(dto);
				
			}
			
			return vehicleDto;
		}
		else {
			 
			throw new RuntimeException("User Id not Present");
		}

		
	}




	@Override
	public ParkingVehicleAccountDTO getDefault(long id) {

		
		ParkingUser parkingUser = parkingUserRepo.findById(id);
		
		if(parkingUser !=null) {
			
			ParkingVehicleAccount vehicle = parkingVehicleAccountRepo.findByParkingUserIdAndDefaultVehicle(id,true);
			
				
				ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
				dto.setId(vehicle.getId());
				dto.setUserId(vehicle.getParkingUser().getId());
				dto.setVehicleName(vehicle.getVehicleName());
				dto.setVehicleNo(vehicle.getVehicleNo());
				dto.setStatus(vehicle.getStatus());
				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setFavVehicle(vehicle.isFavVehicle());
				dto.setCreatedOn(vehicle.getCreatedOn());
				dto.setUpdatedOn(vehicle.getUpdatedOn());
				
			
				return dto;
		}
		else {
			 
			throw new RuntimeException("User Id not Present");
		}
	
	}




	@Override
	public List<ParkingVehicleAccountDTO> getFavAll(long id) {


		ParkingUser parkingUser = parkingUserRepo.findById(id);
		
		if(parkingUser !=null) {
			
			List<ParkingVehicleAccount> vehicleList = parkingVehicleAccountRepo.findByParkingUserIdAndFavVehicle(id,true);
			List<ParkingVehicleAccountDTO> vehicleDto = new  ArrayList<ParkingVehicleAccountDTO>();
			
			for (ParkingVehicleAccount vehicle : vehicleList) {
				
				ParkingVehicleAccountDTO dto = new ParkingVehicleAccountDTO();
				dto.setId(vehicle.getId());
				dto.setUserId(vehicle.getParkingUser().getId());
				dto.setVehicleName(vehicle.getVehicleName());
				dto.setVehicleNo(vehicle.getVehicleNo());
				dto.setStatus(vehicle.getStatus());
				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setFavVehicle(vehicle.isFavVehicle());
				dto.setCreatedOn(vehicle.getCreatedOn());
				dto.setUpdatedOn(vehicle.getUpdatedOn());
				
				vehicleDto.add(dto);
				
			}
			
			return vehicleDto;
		}
		else {
			 
			throw new RuntimeException("User Id not Present");
		}
		
	}


}
