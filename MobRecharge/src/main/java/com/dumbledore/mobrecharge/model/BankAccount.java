package com.dumbledore.mobrecharge.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class BankAccount {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;

	@NotNull
	@Column(unique = true)
	long accountNumber;
	@Size(min = 5, message = "ownername should have atleast 5 character")
	String ownerName;
	@Size(min = 8, max = 8, message = "ifsc code should be 8 character")
	String ifscCode;
	@Size(min = 5, message = "branch name  should have atleast 5 character")
   	String branch;
    @NotNull
    @PositiveOrZero
	float balance;
    
    @NotNull
	String dateOfCreation;
	@Size(min = 3, message = "bankname should have atleast 5 character")
	
    @NotNull
	String bankName;

	public BankAccount() {
		this.dateOfCreation = (new Date()).toString();
	}

	public Integer getBankid() {
		return bankId;
	}

	public void setBankid(Integer bankid) {
		this.bankId = bankid;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getBranch() {
		
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
}
