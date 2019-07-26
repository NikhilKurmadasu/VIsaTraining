package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Employee;

public interface UserDao extends JpaRepository<Employee, Integer> {

}
