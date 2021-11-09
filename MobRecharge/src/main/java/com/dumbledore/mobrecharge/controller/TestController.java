package com.dumbledore.mobrecharge.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1.0/mobrecharge/auth/test")
public class TestController {
	
	@GetMapping("/all")
	public String allAccess() {
		return "This is a public API need no authorization";
	}
	
	@GetMapping("/user")
//	@Secured({"ROLE_USER, ROLE_MODERATOR"})
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "You can now access this API";
	}

	@GetMapping("/moderator")
	@Secured("MODERATOR")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@Secured("ADMIN")
	public String adminAccess() {
		return "Admin Board.";
	}
}
