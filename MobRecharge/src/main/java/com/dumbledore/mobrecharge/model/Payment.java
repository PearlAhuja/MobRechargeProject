package com.dumbledore.mobrecharge.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dumbledore.mobrecharge.model.myenum.Status;
import com.sun.istack.NotNull;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer paymentId;
	@NotNull
	private float amount;
	@NotNull
	private String dateOfPayment;
	@NotNull
	private Status status;

	public Payment() {
		this.dateOfPayment = (new Date()).toString();
	}

	public Payment(float amount, String dateOfPayment, Status status) {
		super();
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.status = status;
	}

	public Payment(Integer paymentId, float amount, String dateOfPayment, Status status) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.status = status;
	}

	/*
	 * @Getters
	 * 
	 * @Setters
	 */
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
