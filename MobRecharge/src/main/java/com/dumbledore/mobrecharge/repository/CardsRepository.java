package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.CardDetail;

@Repository
public interface CardsRepository extends JpaRepository<CardDetail , Integer>{

	public CardDetail findBynameOnCard(String nameOnCard);

	public CardDetail deleteByNameOnCard(String nameOnCard);

}
