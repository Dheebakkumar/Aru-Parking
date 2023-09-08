package com.parkingProject.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingOrderDTO {

		private long id;
		
		private String description;
		
		private BigDecimal amount;
		
		private String vehicleNo;
		
		private String contactNo;
		
		private String transactionId;
		
		private long userId;
		
		private long slotId;
		
		private Date parkingStartTime;
		
		private Date parkingEndTime;

		private Date createdOn;
		
		private Date lastUpdatedOn;
		
		private long feeId;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public String getVehicleNo() {
			return vehicleNo;
		}

		public void setVehicleNo(String vehicleNo) {
			this.vehicleNo = vehicleNo;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public Date getParkingStartTime() {
			return parkingStartTime;
		}

		public void setParkingStartTime(Date parkingStartTime) {
			this.parkingStartTime = parkingStartTime;
		}

		public Date getParkingEndTime() {
			return parkingEndTime;
		}
		
		

		public void setParkingEndTime(Date parkingEndTime) {
			this.parkingEndTime = parkingEndTime;
		}

		public Date getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Date createdOn) {
			this.createdOn = createdOn;
		}

		public Date getLastUpdatedOn() {
			return lastUpdatedOn;
		}

		public void setLastUpdatedOn(Date lastUpdatedOn) {
			this.lastUpdatedOn = lastUpdatedOn;
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public long getSlotId() {
			return slotId;
		}

		public void setSlotId(long slotId) {
			this.slotId = slotId;
		}

		public long getFeeId() {
			return feeId;
		}

		public void setFeeId(long feeId) {
			this.feeId = feeId;
		}

		
		
		
		
	}