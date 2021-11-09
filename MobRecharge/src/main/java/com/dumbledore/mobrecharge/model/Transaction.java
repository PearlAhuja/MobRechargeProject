package com.dumbledore.mobrecharge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

@Entity
public class Transaction {

	@Id
	@GeneratedValue()
	private Integer id;

	private Integer planId;
	private Integer offerId;
	private Integer paymentId;
	private Long phoneNumber;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Transaction() {
		super();
	}

	public Transaction(Integer id, Integer planId, Integer offerId, Integer paymentId, Long phoneNumber) {
		super();
		this.id = id;
		this.planId = planId;
		this.offerId = offerId;
		this.paymentId = paymentId;
		this.phoneNumber = phoneNumber;
	}

}
