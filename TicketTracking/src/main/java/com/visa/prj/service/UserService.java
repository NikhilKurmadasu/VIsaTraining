package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Employee;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void addUser(Employee p) {
		userDao.save(p);
	}

	public List<Employee> getAllUsers() {
		return userDao.findAll();
	}
}
