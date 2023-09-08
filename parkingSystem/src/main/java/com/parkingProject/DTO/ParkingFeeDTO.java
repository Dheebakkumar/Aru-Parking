package com.parkingProject.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingFeeDTO {

	
	private long id;
	
	private BigDecimal amount;
	
	private String timing;
	
	private Date createOn;
	
	private Date updateOn;


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
	
	
	

	
}
