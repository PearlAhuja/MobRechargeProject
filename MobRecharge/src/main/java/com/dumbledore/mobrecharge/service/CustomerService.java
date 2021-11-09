package com.dumbledore.mobrecharge.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.User;
import com.dumbledore.mobrecharge.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	// TODO : create signIn logic
	public void signIn() {
		
	}
	
	// TODO : create signUp logic
	public void signUp() {
		
	}
	
	
	// Display all the available services
	public List<String> showAllServices() {
		List<String> services = new ArrayList<String>();
		services.add("1. Mobile recharge");
		services.add("2. Show Existing plans");
		return services;
	}
	
	
	// Add customers to database
	public void addCustomer(User customer) {
		customerRepository.save(customer);
	}
	
	
	// search a specific customer by id
	public User searchCustomer(int customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	// List of all customers
	public List<User> findAllCustomers() {
		return customerRepository.findAll();
	}
	
	
	public User findByNumber(Long mobileNumber) {
		return customerRepository.findByMobileNumber(mobileNumber);
	}
    
	
	public void updateCustomer(Long mobileNumber, Long newNumber) {
		
		User customer = findByNumber(mobileNumber);
		customer.setMobileNumber(newNumber);
		customerRepository.save(customer);
	}
    @Transactional
	public void deleteCustomer(Long mobileNumber) {
		customerRepository.deleteByMobileNumber(mobileNumber);
	}
	
	
	
}
