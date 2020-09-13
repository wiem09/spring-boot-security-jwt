package com.jwt.springjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_ETUDIANT') or hasRole('ROLE_ENSEIGNANT') or hasRole('ROLE_ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/enseignant")
	@PreAuthorize("hasRole('ROLE_ENSEIGNANT')")
	public String moderatorAccess() {
		return "enseignant Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}