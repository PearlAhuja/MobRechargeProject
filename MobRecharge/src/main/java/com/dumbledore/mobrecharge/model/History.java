	package com.dumbledore.mobrecharge.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dumbledore.mobrecharge.model.myenum.Status;


/*
 *  This is not an entity class, just a wrapper over 
 *   repository/TransactionRepository - for Query method
 */
public class History {

	
	private String plan;
	private float planAmount;
	private float paidAmount;
	private String dateOfPayment;
	private float offerAmount;
	private Status status;
	private BigInteger rechargeTo;
	private String name;

	
	
	
	/*
	 * @NoArgConstructor
	 */
	public History() {
	}



	/*
	 * @Getters
	 *    &
	 * @Setters
	 */
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public float getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(float planAmount) {
		this.planAmount = planAmount;
	}
	public float getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(float paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public float getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(float offerAmount) {
		this.offerAmount = offerAmount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BigInteger getRechargeTo() {
		return rechargeTo;
	}
	public void setRechargeTo(BigInteger bigInteger) {
		this.rechargeTo = bigInteger;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
