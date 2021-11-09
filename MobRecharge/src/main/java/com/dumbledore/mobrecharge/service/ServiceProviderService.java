package com.dumbledore.mobrecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.Plan;
import com.dumbledore.mobrecharge.model.ServiceProvider;
import com.dumbledore.mobrecharge.model.myenum.Provider;
import com.dumbledore.mobrecharge.repository.PlansRepository;
import com.dumbledore.mobrecharge.repository.ServiceProviderRepository;


@Service
public class ServiceProviderService {
	
	Provider providers;

	@Autowired
	ServiceProviderRepository providerRepository;
	
	@Autowired
	PlansRepository plans;

	// Get All Plans a service provider provides
	public List<Plan> showAllPlans(ServiceProvider serviceProvider)
	{
		return plans.findAll();
	}
	
	
	// Add a new Service Provider
	public void add(ServiceProvider serviceProvider) {
		providerRepository.save(serviceProvider);
		
	}
	
	public List<Provider> getAll()
	{
		return (java.util.Arrays.asList(providers.values()));
	}
	

}
