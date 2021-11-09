package com.dumbledore.mobrecharge.repository;

import java.util.List;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dumbledore.mobrecharge.model.History;
import com.dumbledore.mobrecharge.model.Transaction;

@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByPhoneNumber(Long phoneNumber);

	
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "Select pl.type_of_plan as plan,  pl.amount as planAmount, py.amount as paidAmount , py.date_of_payment , o.amount as offerAmount , py.status , t.phone_number as rechargeTo , u.first_name as Name from plan pl , payment py , transaction t , users u , offer o where t.user_id = u.user_id and t.payment_id = py.payment_id and t.plan_id = pl.plan_id and t.offer_id = o.offer_id", nativeQuery = true)
	List<Tuple> findTransactions(@Param("userId") int userId);

}
