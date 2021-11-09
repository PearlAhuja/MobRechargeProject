package com.dumbledore.mobrecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dumbledore.mobrecharge.exception.InvalidArgumentException;

import com.dumbledore.mobrecharge.CurrentUser;

import com.dumbledore.mobrecharge.model.Payment;
import com.dumbledore.mobrecharge.model.Transaction;
import com.dumbledore.mobrecharge.service.OfferService;
import com.dumbledore.mobrecharge.service.PaymentService;
import com.dumbledore.mobrecharge.service.PlanService;
import com.dumbledore.mobrecharge.service.TransactionService;

@RequestMapping("/v1.0/mobrecharge/auth/payment")
@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	PlanService planService;
	@Autowired
	OfferService offerService;

	// Make Payment after applying an offer using its offer id
	@PostMapping("/pay")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> makePayment(@RequestBody Transaction transaction) {
		transaction.setUserId(CurrentUser.CURRENT_USER_ID);
		String result = "";
		int planId = transaction.getPlanId();
		int offerId = transaction.getOfferId();
		long phoneNumber = transaction.getPhoneNumber();

		
		List<Float> amount = paymentService.calculateAmount(planId, offerId);
		
		result += "Plan Amount : ";
		result += (Float.toString(amount.get(0)));
		
		result += "\n\nOffer Amount Applied : ";
		result += (Float.toString(amount.get(1)));

		Payment payment = paymentService.saveAmount(amount.get(2));
		int payId = payment.getPaymentId();

		if (amount.get(2) >= 0) {
			result += "\n\nAmount to be paid : ";
			result += (Float.toString(amount.get(2)));
			result += "\n\nPayment Sucessfull !!";
		} else {
			result += "Recharge Unsuccessfull";
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}

		transaction.setPaymentId(payId);
		transactionService.saveTransaction(transaction);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Payment>> Payments() {
		return new ResponseEntity<>(paymentService.getAllPayment(), HttpStatus.ACCEPTED);

	}

	@GetMapping("/transactionhistory/{phoneNumber}")
	public ResponseEntity<List<Transaction>> transactionHistory(@PathVariable Long phoneNumber) {
		try {
			return new ResponseEntity<>(transactionService.showByNumber(phoneNumber), HttpStatus.ACCEPTED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

}
