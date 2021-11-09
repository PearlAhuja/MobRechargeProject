package com.dumbledore.mobrecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.History;
import com.dumbledore.mobrecharge.model.Transaction;
import com.dumbledore.mobrecharge.service.TransactionService;

@RestController()
@RequestMapping("/v1.0/mobrecharge/auth/transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionService;


	@GetMapping("/{userId}")
	public List<History> getTransaction(@PathVariable int userId) {
		return transactionService.getHistory(userId);
	}
}
