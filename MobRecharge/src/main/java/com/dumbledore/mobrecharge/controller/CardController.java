package com.dumbledore.mobrecharge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.model.CardDetail;
import com.dumbledore.mobrecharge.service.BankService;
import com.dumbledore.mobrecharge.service.CardService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/accountdetails/card")
public class CardController {
	@Autowired
	CardService cardService;

	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String addNewCardDetails(@Valid @RequestBody CardDetail cardDetail) {
		cardService.saveCardDetails(cardDetail);
		return "Card Details Successfully Added";

	}

	@GetMapping("/{nameOnCard}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public CardDetail getDetailsByUserName(@PathVariable String nameOnCard) {
		return cardService.getDetail(nameOnCard);
	}

	@DeleteMapping("/{nameOnCard}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String deleteCardDetailByNameOnCard(@PathVariable String nameOnCard) {
		cardService.deleteCardDetail(nameOnCard);
		return "Successfully Deleted CardDetails";
	}

}
