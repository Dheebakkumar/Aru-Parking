package com.parkingProject.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PARKING_VEHICLE_ACCOUNT")
public class ParkingVehicleAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="VEHICLE_NO")
	private String vehicleNo;
	
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	@Column(name="DEFAULT_VEHICLE")
	private boolean defaultVehicle;
	
	@Column(name="FAV_VEHICLE")
	private boolean favVehicle;
	
	@Column(name="STATUS")
	private int status;
	
	@ManyToOne
	@JoinColumn(name="USER_ID" )
	private ParkingUser parkingUser;
	
	@Column(name="CREATED_ON" ,updatable  = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="UPDATED_NO")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedOn;
	
	

	public ParkingVehicleAccount() {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ParkingUser getParkingUser() {
		return parkingUser;
	}

	public void setParkingUser(ParkingUser parkingUser) {
		this.parkingUser = parkingUser;
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

	public boolean isDefaultVehicle() {
		return defaultVehicle;
	}

	public void setDefaultVehicle(boolean defaultVehicle) {
		this.defaultVehicle = defaultVehicle;
	}

	public boolean isFavVehicle() {
		return favVehicle;
	}

	public void setFavVehicle(boolean favVehicle) {
		this.favVehicle = favVehicle;
	}
	
		
}
