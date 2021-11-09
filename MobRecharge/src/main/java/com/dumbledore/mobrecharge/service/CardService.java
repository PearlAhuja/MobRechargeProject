package com.dumbledore.mobrecharge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.model.CardDetail;
import com.dumbledore.mobrecharge.repository.CardsRepository;

@Service
public class CardService {
	@Autowired
	CardsRepository cardRepository;
	
	public void saveCardDetails(CardDetail cardDetail)
	{
		cardRepository.save(cardDetail);
	}

	public CardDetail getDetail(String nameOnCard) {
		return cardRepository.findBynameOnCard(nameOnCard);
	}


	public void deleteCardDetail(String nameOnCard) {
	   cardRepository.deleteByNameOnCard(nameOnCard);
		
	}


}
