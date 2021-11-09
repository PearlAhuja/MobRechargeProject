package com.dumbledore.mobrecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.Plan;
import com.dumbledore.mobrecharge.model.ServiceProvider;
import com.dumbledore.mobrecharge.model.myenum.Provider;
import com.dumbledore.mobrecharge.service.PlanService;
import com.dumbledore.mobrecharge.service.ServiceProviderService;

@RequestMapping("/v1.0/mobrecharge/auth/services")
@RestController

public class ServiceProviderController {
	@Autowired
	ServiceProviderService providerService;

	@Autowired
	PlanService plans;

	@PostMapping("/{phoneNumber}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Plan>> mobileRecharge(@RequestBody ServiceProvider serviceProvider,
			@PathVariable long phoneNumber) {

		serviceProvider.setPhoneNumber(phoneNumber);
		return new ResponseEntity<>(providerService.showAllPlans(serviceProvider), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Provider>> showAllProviders() {
		return new ResponseEntity<>(providerService.getAll(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/addprovider")
	@PreAuthorize("hasRole('ADMIN')")
	public String addServiceProvider(ServiceProvider serviceProvider) {
		providerService.add(serviceProvider);
		return "New Service Provider Sucessfully Added !!";
	}

	@PostMapping("/mobileRecharge")
	@PreAuthorize("hasRole('ADMIN')")
	List<Plan> mobileRecharge(@RequestBody ServiceProvider serviceProvider) {
		return providerService.showAllPlans(serviceProvider);
	}

}
