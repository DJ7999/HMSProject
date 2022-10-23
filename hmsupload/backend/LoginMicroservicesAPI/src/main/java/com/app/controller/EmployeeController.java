package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.temp.AuthRequest;
import com.app.dto.temp.AuthResp;
import com.app.jwt_utils.JwtUtils;
import com.app.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hms/login")
@CrossOrigin
@Slf4j
public class EmployeeController {

	
	
	@Autowired
	private JwtUtils utils;
	@Autowired
	EmployeeRepository empRepo;
	// dep : Auth mgr
	@Autowired
	private AuthenticationManager manager;
	
	
	// add a method to authenticate user . In case of success --send back token , o.w
	// send back err mesg
	@PostMapping("/signin")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request) {
		// store incoming user details(not yet validated) into Authentication object
		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getName(),
				request.getPassword());
		log.info("auth token before {}",authToken);
		try {
			// authenticate the credentials
			Authentication authenticatedDetails = manager.authenticate(authToken);
			log.info("auth token again {} " , authenticatedDetails);
			Long deptId=empRepo.findByName(request.getName()).get().getDeptId().getDeptId();
			Long empId=empRepo.findByName(request.getName()).get().getEmpId();
			return ResponseEntity.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticatedDetails),deptId,empId));
		} catch (BadCredentialsException e) { // lab work : replace this by a method in global exc handler
			// send back err resp code
			System.out.println("err "+e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
}
}