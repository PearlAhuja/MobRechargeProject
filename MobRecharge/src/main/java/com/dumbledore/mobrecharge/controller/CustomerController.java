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
import com.dumbledore.mobrecharge.model.User;
import com.dumbledore.mobrecharge.service.CustomerService;

@RestController
@RequestMapping(value = "/v1.0/mobrecharge/auth/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/getallcustomers")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllCustomers() { // LIST OF ALL CUSTOMERS
		return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.ACCEPTED);
	}

	
	@GetMapping(value = "/{number}")
	public ResponseEntity<User> getCustomerByNumber(@PathVariable Long number) {
		try {
			return new ResponseEntity<>(customerService.findByNumber(number), HttpStatus.FOUND);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@PutMapping("/{number}/{newNumber}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> updateCustomerNumber(@PathVariable Long number, @PathVariable Long newNumber) {
		try {
			customerService.updateCustomer(number, newNumber);
			return new ResponseEntity<>("Customer Number Updated !!", HttpStatus.OK);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (NullPointerException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@DeleteMapping("/{number}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteCustomerByNumber(@PathVariable Long number) {
		try {
			customerService.deleteCustomer(number);
			return new ResponseEntity<>("Customer details removed sucessfully", HttpStatus.OK);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (NullPointerException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@GetMapping("/services")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<String>> getAllServices() {
		return new ResponseEntity<>(customerService.showAllServices(), HttpStatus.OK);
	}

}
