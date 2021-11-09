package com.dumbledore.mobrecharge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.Offer;
import com.dumbledore.mobrecharge.model.Payment;
import com.dumbledore.mobrecharge.model.Plan;
import com.dumbledore.mobrecharge.model.myenum.Status;
import com.dumbledore.mobrecharge.repository.OffersRepository;
import com.dumbledore.mobrecharge.repository.PaymentRepository;
import com.dumbledore.mobrecharge.repository.PlansRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	PlansRepository plansRepository;

	Payment payment;

	// make payment
//	public Payment makePayment(Payment payment ) {
//		return paymentRepository.save(payment);
//	}

	// get payment by id
	public Payment getDetail(Integer paymentId) {
		Payment payment = paymentRepository.findById(paymentId).get();
		return payment;
	}

	@Autowired
	OffersRepository offerRepository;

	Offer offer;
	Plan plan;

	// get all payment
	public List<Payment> getAllPayment() {
		return paymentRepository.findAll();
	}

	public List<Float> calculateAmount(int planId, int offerId) {

		float offerValue = 0;
		float planValue = 0;
		offer = offerRepository.findById(offerId).get();
		plan = plansRepository.findById(planId).get();
		if (plan != null) {
			planValue = plan.getAmount();

		} else {
			System.out.println("Try Again");
			return null;
		}
		if (offer != null) {
			offerValue = offer.getAmount();
			System.out.println("Offer Sucessfully Applied !!");
		} else {
			System.out.println("Choose a suitable one");
		}

		List<Float> values = new ArrayList<>();
		values.add(plan.getAmount());
		values.add(offer.getAmount());
		values.add(planValue - offerValue);
		return values;
	}

	// Set payment details
	public Payment saveAmount(float amount) {

		System.out.println(amount);

		payment = new Payment();

		payment.setAmount(amount);
		if (amount != -1) {
			payment.setStatus(Status.SUCCESSFUL);
		} else {
			payment.setStatus(Status.FAILED);
		}

		return paymentRepository.save(payment);

	}
}
