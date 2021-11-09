package com.dumbledore.mobrecharge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dumbledore.mobrecharge.exception.InvalidArgumentException;
import com.dumbledore.mobrecharge.exception.ResourceNotFoundException;
import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.service.BankService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/accountdetails")
public class BankController {
	@Autowired
	BankService bankService;

	@GetMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<BankAccount>> getAllDetails() {
		try {
			return new ResponseEntity<>(bankService.getAllBankDetails(), HttpStatus.OK);
		} catch (ResourceNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank Account Not Found", exc);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteAllBankDetails() {
		try {
			bankService.deleteBankDetails();
			return new ResponseEntity<>("Successfully Deleted Details", HttpStatus.ACCEPTED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (NullPointerException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> addNewAccountDetails(@Valid @RequestBody BankAccount bankAccount) {
		try {
			bankService.saveBankDetails(bankAccount);
			return new ResponseEntity<>("Sucessfully added bank account", HttpStatus.CREATED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}

	}

	@GetMapping("/{accountNumber}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<BankAccount> getDetailsByAccountNumber(@PathVariable long accountNumber) {
		return new ResponseEntity<>(bankService.getDetailByAccountNumber(accountNumber), HttpStatus.OK);

	}

	@DeleteMapping("/{accountNumber}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteAllBankDetails(@PathVariable long accountNumber) {
		try {
			bankService.deleteBankDetailbyAccountNumber(accountNumber);
			return new ResponseEntity<>("Successfully Deleted AccountDetails", HttpStatus.ACCEPTED);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (IllegalArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		} catch (NullPointerException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

}
