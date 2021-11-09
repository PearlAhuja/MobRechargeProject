package com.dumbledore.mobrecharge.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dumbledore.mobrecharge.model.Offer;
import com.dumbledore.mobrecharge.model.Plan;

@Transactional
public interface OffersRepository extends JpaRepository<Offer , Integer> {

	
	List<Offer> findAllByPlan(Plan plan);

//	void deletePlans(int planId);
	@Modifying
	@Query(value = "delete from offer where offer.plan_id=:planId", nativeQuery = true
			) 
	public void deleteAllByPlan(@Param("planId") Integer planId);
	

}
