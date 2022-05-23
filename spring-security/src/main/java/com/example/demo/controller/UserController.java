package com.example.demo.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")

public class UserController {
	
	@GetMapping(path="/users")
	
	public String getUser(Principal principal) {
		System.out.println("User:="+principal.getName());
		System.out.println(principal.toString());
		return "User Sriharish";
	}
@GetMapping(path="/users/{id}")

@RolesAllowed(value= {"ROLE_ADMIN","ROLE_GUEST"})

public String getUserById(@PathVariable int id) {
	if(id==1) {
		return "User Sriharish";
		
	}else {
		return "Manager Magesh";
	}
}
}
