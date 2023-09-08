package com.parkingProject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PARKING_ZONE")
public class ParkingZone implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name="ID")
	private long id;
	
	@Column(name="NAME_ZONE")
	private String nameZone;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="CREATED_ON", updatable =false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="UPDATED_ON" )
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@OneToMany(mappedBy="parkingZone")
	private List<ParkingSlots> parkingSlots;
	

	public ParkingZone() {
		super();
		// TODO Auto-generated constructor stub
	}


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


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	public List<ParkingSlots> getParkingSlots() {
		return parkingSlots;
	}


	public void setParkingSlots(List<ParkingSlots> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}


	@Override
	public String toString() {
		return "ParkingZone [id=" + id + ", nameZone=" + nameZone + ", status=" + status + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", parkingSlots=" + parkingSlots + "]";
	}

	
	
	

}
