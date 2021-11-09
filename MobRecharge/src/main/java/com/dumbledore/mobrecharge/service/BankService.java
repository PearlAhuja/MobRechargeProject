package com.dumbledore.mobrecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;

	public BankAccount saveBankDetails(BankAccount bankAccount) {
		return bankRepository.save(bankAccount);
	}

	public List<BankAccount> getAllBankDetails() {
		return bankRepository.findAll();
	}

	public void deleteBankDetails() {
		bankRepository.deleteAll();

	}

	public BankAccount getDetailByAccountNumber(long accountNumber) {
		return bankRepository.findByAccountNumber(accountNumber);
	}

	public void  deleteBankDetailbyAccountNumber(long accountNumber) {
		BankAccount account = bankRepository.findByAccountNumber(accountNumber);
		int accountId = account.getBankid();
		bankRepository.deleteById(accountId);    
	}

}
