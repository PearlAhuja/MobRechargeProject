package com.dumbledore.mobrecharge.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.History;
import com.dumbledore.mobrecharge.model.Transaction;
import com.dumbledore.mobrecharge.model.myenum.Status;
import com.dumbledore.mobrecharge.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	// save transaction
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	// display all transaction
	List<Transaction> showAll() {
		return transactionRepository.findAll();
	}

	public List<Transaction> showByNumber(Long phoneNumber) {
		return transactionRepository.findByPhoneNumber(phoneNumber);
	}

	/*
	 * Main class which converts the Query from repository to History Json with
	 * required fields ref : model/History
	 */
	public List<History> getHistory(int userId) {

		List<Tuple> tuples = transactionRepository.findTransactions(userId);

		List<History> listOfHistory = new ArrayList<>();

		tuples.stream().map(t -> {

			History history = new History();

			history.setPlan(t.get(0).toString());
			history.setPlanAmount((float) t.get(1));
			history.setPaidAmount((float) t.get(2));
			history.setDateOfPayment(t.get(3).toString());
			history.setOfferAmount((float)t.get(4));

			int status = (int) t.get(5);
			switch (status) {

			case 0:
				history.setStatus(Status.SUCCESSFUL);
				break;
			case 1:
				history.setStatus(Status.FAILED);
				break;
			case 2:
				history.setStatus(Status.FAILED);
				history.setStatus(Status.DENIED);
				break;
			default:
				history.setStatus(Status.FAILED);
				break;

			}
			history.setRechargeTo((BigInteger) t.get(6));
		//	history.setRechargeTo((String) t.get(6));
			history.setName(t.get(7).toString());
			listOfHistory.add(history);
			return listOfHistory;
		}

		).collect(Collectors.toList());

		return listOfHistory;
	}

}
