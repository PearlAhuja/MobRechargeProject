package com.dumbledore.mobrecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dumbledore.mobrecharge.exception.InvalidArgumentException;
import com.dumbledore.mobrecharge.exception.ResourceNotFoundException;
import com.dumbledore.mobrecharge.model.Offer;
import com.dumbledore.mobrecharge.service.OfferService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/offers")
public class OfferController {
	@Autowired
	OfferService offerService;

	@PostMapping("/add/{planId}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> addOffer(@PathVariable int planId, @RequestBody List<Offer> offers) {

		offerService.createOffer(offers, planId);
		return new ResponseEntity<String>("Offer(s) Sucessfully added !!", HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllOffers() {
		return new ResponseEntity<>(offerService.getOffers(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{planId}")
	public ResponseEntity<?> getAllOffersByPlanId(@PathVariable int planId) {
		try {
			return new ResponseEntity<>(offerService.getOffersByPlanId(planId), HttpStatus.ACCEPTED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@DeleteMapping("/offer/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteOffer(@PathVariable int id) {
		try {
			offerService.deleteOffer(id);
			return new ResponseEntity<>("Offer deleted !!", HttpStatus.ACCEPTED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@DeleteMapping("/plan/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteOfferByPlanId(@PathVariable int id) {
		try {
			offerService.deleteOfferByPlan(id);
			return new ResponseEntity<>("Offer deleted !!", HttpStatus.ACCEPTED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	ResponseEntity<?> updateOffer(@PathVariable Integer id, @RequestBody Offer offer) {
		try {
			offerService.updateOffer(id, offer);
			return new ResponseEntity<>("offer updated sucessfully ",HttpStatus.OK);
		} catch (ResourceNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Offer Not Found", exc);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

}
