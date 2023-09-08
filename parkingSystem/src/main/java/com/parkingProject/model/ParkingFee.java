package com.parkingProject.model;

import java.math.BigDecimal;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PARKING_FEE")
public class ParkingFee {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;
	
	@Column(name="TIMING")
	private String timing;
	
	@Column(name="CREATED_ON", updatable =false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createOn;
	
	@Column(name="UPDATED_ON" )
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateOn;
	
	//@OneToMany(mappedBy="parkingFee")
	//private List<ParkingOrder> parkingOrder;
	

	public ParkingFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
//
//	public List<ParkingOrder> getParkingOrder() {
//		return parkingOrder;
//	}
//
//	public void setParkingOrder(List<ParkingOrder> parkingOrder) {
//		this.parkingOrder = parkingOrder;
	
	
//	}

	
	
}






