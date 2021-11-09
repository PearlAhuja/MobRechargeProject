package com.dumbledore.mobrecharge.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planId;

	@OneToMany(mappedBy = "plan", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Offer> offerlist;

	private int validityOfPlan;

	private float amount;
	@NotEmpty
	@Size(min = 3, message = "type of plan  should have at least 3 characters")
	private String typeOfPlan;

	public Plan() {
	}

	public List<Offer> getOfferlist() {
		return offerlist;
	}

	public void setOfferlist(List<Offer> offerlist) {
		this.offerlist = offerlist;
	}

	public Plan(int planId, int validityOfPlan, float amount, String typeOfPlan) {
		super();
		this.planId = planId;
		this.validityOfPlan = validityOfPlan;
		this.amount = amount;
		this.typeOfPlan = typeOfPlan;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getValidityOfPlan() {
		return validityOfPlan;
	}

	public void setValidityOfPlan(int validityOfPlan) {
		this.validityOfPlan = validityOfPlan;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTypeOfPlan() {
		return typeOfPlan;
	}

	public void setTypeOfPlan(String typeOfPlan) {
		this.typeOfPlan = typeOfPlan;
	}

}
