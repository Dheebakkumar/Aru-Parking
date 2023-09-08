package com.parkingProject.DTO;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.parkingProject.model.ParkingSlots;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class ParkingZoneDTO {
	
	private long id;
	
	private String nameZone;
	
	private int status;
	
	private Date createdOn;
	
	private Date updatedOn;
	
	private List<ParkingSlots> parkingSlots;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameZone() {
		return nameZone;
	}

	public void setNameZone(String nameZone) {
		this.nameZone = nameZone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateOn() {
		return createdOn;
	}

	public void setCreateOn(Date createOn) {
		this.createdOn = createOn;
	}

	public Date getUpdateOn() {
		return updatedOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updatedOn = updateOn;
	}
	

}


