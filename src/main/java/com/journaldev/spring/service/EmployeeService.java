package com.journaldev.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.journaldev.spring.dao.EmployeeRepository;
import com.journaldev.spring.entity.Employee;

@Service
public class EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

}