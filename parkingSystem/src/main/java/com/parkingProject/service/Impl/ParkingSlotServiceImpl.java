package com.parkingProject.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingProject.DTO.ParkingSlotDTO;
import com.parkingProject.model.ParkingSlots;
import com.parkingProject.model.ParkingZone;
import com.parkingProject.repository.ParkingSlotRepo;
import com.parkingProject.repository.ParkingZoneRepo;
import com.parkingProject.service.ParkingSlotService;


@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Autowired
	ParkingZoneRepo parkingZoneDTO;
	
	@Override
//	public ParkingSlotDTO addSlots(ParkingSlotDTO parkingSlotDto) {
		
	public Object addSlots(ParkingSlotDTO parkingSlotDto) {
		
		ParkingZone parkingZone=parkingZoneDTO.findById(parkingSlotDto.getZoneId());
		
		if(parkingZone !=null) {
			
		ParkingSlots checkNameAndZoneId = parkingSlotRepo.findBySlotNameAndParkingZoneId(parkingSlotDto.getSlotName(),parkingSlotDto.getZoneId());
		
			if(checkNameAndZoneId ==null) {
				ParkingSlots parkingSlots = new ParkingSlots();
				parkingSlots.setSlotName(parkingSlotDto.getSlotName());
				parkingSlots.setStatus(1);
				parkingSlots.setParkingZone(parkingZone);
				ParkingSlots saveSlot = parkingSlotRepo.save(parkingSlots);
				
				return create(saveSlot);
			}
			else {
				
				throw new RuntimeException("SlotName is Already Present in This Zone");
				
//				Map<String,String> map = new HashMap<String,String>();
//				map.put("Error", "SlotName is Already Present in This Zone");
//				return map;
			}
		
		}
		else {
			
			throw new RuntimeException("ZoneID Not Present");
//			List<String> list = new ArrayList<String>();
//			list.add("ZoneID Not Present");
//			return list;
			
		}
		
	}
	
	public ParkingSlotDTO create(ParkingSlots saveSlot) {
			ParkingSlotDTO dto = new ParkingSlotDTO();
			
			dto.setId(saveSlot.getId());
			dto.setSlotName(saveSlot.getSlotName());
			dto.setStatus(1);
			dto.setZoneId(saveSlot.getParkingZone().getId());
			dto.setCreatedOn(saveSlot.getCreatedOn());
			dto.setUpdatedOn(saveSlot.getUpdatedOn());
			dto.setZoneId(saveSlot.getParkingZone().getId());
			
			return dto;
	}

	@Override
	public ParkingSlotDTO getBySlot(long id) {
		
		ParkingSlots parkingSlot = parkingSlotRepo.findById(id);

		ParkingSlotDTO dto = new ParkingSlotDTO();
		dto.setId(parkingSlot.getId());
		dto.setSlotName(parkingSlot.getSlotName());
		dto.setStatus(parkingSlot.getStatus());
		dto.setCreatedOn(parkingSlot.getCreatedOn());
		dto.setUpdatedOn(parkingSlot.getUpdatedOn());
		dto.setZoneId(parkingSlot.getParkingZone().getId());
		
		return dto;
		
	}

	@Override
	public List<ParkingSlotDTO> getAllSlots() {


		List<ParkingSlots> parkingSlotsList = parkingSlotRepo.findAll();
		List<ParkingSlotDTO> parkingSlotDto = new ArrayList();
		
		for (ParkingSlots parkingSlot : parkingSlotsList) {
			
			ParkingSlotDTO dto = new ParkingSlotDTO();
			dto.setId(parkingSlot.getId());
			dto.setSlotName(parkingSlot.getSlotName());
			dto.setStatus(parkingSlot.getStatus());
			dto.setCreatedOn(parkingSlot.getCreatedOn());
			dto.setUpdatedOn(parkingSlot.getUpdatedOn());
			dto.setZoneId(parkingSlot.getParkingZone().getId());
			
			parkingSlotDto.add(dto);
			
		}
		return parkingSlotDto;
	}

	@Override
	public ParkingSlotDTO updateSlot(ParkingSlotDTO parkingSlotDto) {
		
		ParkingSlots ParkingSlot = parkingSlotRepo.findById(parkingSlotDto.getId());
		
		if(ParkingSlot !=null) {
//		Optional<ParkingZone> op = userRepo.findById(parkingSlotDto.getId());
//		ParkingZone zone = op.get();
			
			ParkingSlots checkNameAndZoneId = parkingSlotRepo.findBySlotNameAndParkingZoneId(parkingSlotDto.getSlotName(),parkingSlotDto.getZoneId());
			
			if(checkNameAndZoneId ==null) {

				ParkingSlot.setSlotName(parkingSlotDto.getSlotName());
				ParkingSlot.setStatus(parkingSlotDto.getStatus());
				
				ParkingSlots saveSlot = parkingSlotRepo.save(ParkingSlot);
				
				return update(saveSlot);
			}
			else {
				
				throw new RuntimeException("SlotName is Already Present in This Zone...");
			}
		}
		else {
			
			
			throw new RuntimeException("ID is Not Present...");
		}
		
	}
	
	public ParkingSlotDTO update(ParkingSlots saveSlot) {
		
		ParkingSlotDTO dto = new ParkingSlotDTO();
		dto.setId(saveSlot.getId());
		dto.setSlotName(saveSlot.getSlotName());
		dto.setStatus(saveSlot.getStatus());
		dto.setCreatedOn(saveSlot.getCreatedOn());
		dto.setUpdatedOn(saveSlot.getUpdatedOn());
		dto.setZoneId(saveSlot.getParkingZone().getId());
		
		return dto;
		
	}
	
	

	



}
