package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Employee;
import com.visa.prj.service.UserService;

@RestController
public class UserConroller {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public @ResponseBody List<Employee> getAllUsers(){
		return service.getAllUsers();
	}
	@PostMapping("/users")
	public ResponseEntity<Employee> addUser(@RequestBody Employee e){
		service.addUser(e);
		return new ResponseEntity<Employee>(e,HttpStatus.CREATED);
	}
}
