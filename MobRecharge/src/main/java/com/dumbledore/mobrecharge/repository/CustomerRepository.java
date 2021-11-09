package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<User , Integer> {

	
	public User findByMobileNumber(Long mobileNumber);
	public void deleteByMobileNumber(Long mobileNumber);
	
}
