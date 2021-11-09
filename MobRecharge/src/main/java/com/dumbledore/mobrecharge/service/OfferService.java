package com.dumbledore.mobrecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.Offer;
import com.dumbledore.mobrecharge.model.Plan;
import com.dumbledore.mobrecharge.repository.OffersRepository;
import com.dumbledore.mobrecharge.repository.PlansRepository;

@Service
public class OfferService {
	@Autowired
	OffersRepository offersRepository;

	@Autowired
	PlansRepository plansRepository;
	
	// Get all Offers
	public List<Offer> getOffers() {
		return offersRepository.findAll();
	}

	// get offer by given id
	public Offer getOffersById(Integer id) {
		return offersRepository.findById(id).get();
	}

// -------------------------------- Admin Controls ------------------------------------
	// add offer
	public void createOffer(List<Offer> offers, int planId) {
		
		for(Offer offer : offers) {

			Plan plan = plansRepository.findById(planId).get();
			offer.setPlan(plan);
			offersRepository.save(offer);
		}
		
		
	}

	// delete offer
	public void deleteOffer(Integer id) {
		offersRepository.deleteById(id);
	}

	// Update Offer
	public void updateOffer(Integer id, Offer offer) {
		if (id == 0 || offer == null) {
			throw new RuntimeException("Offer does not exist");
		}
		Offer existingoffer = offersRepository.findById(id).get();
		existingoffer.setAmount(offer.getAmount());
		existingoffer.setValidThru(offer.getValidThru());

	}

	public List<Offer> getOffersByPlanId(int planId) {
		Plan plan = plansRepository.findById(planId).get();
		return offersRepository.findAllByPlan(plan);
	}

	public void deleteOfferByPlan(int planId) {
		Plan plan = plansRepository.findById(planId).get();
		offersRepository.deleteAllByPlan(planId);
		
//		offersRepository.deletePlans(planId);
		
	}
}