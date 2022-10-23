package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;
@Service
@Transactional
public class CustomEmployeeDetailsServiceImpl implements UserDetailsService {
	@Autowired 
	EmployeeRepository empRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp= empRepo.findByName(username).orElseThrow(()->new UsernameNotFoundException("invalid user name"));
		System.out.println(emp);
		return new CustomUserDetails(emp);
	}

	
}
