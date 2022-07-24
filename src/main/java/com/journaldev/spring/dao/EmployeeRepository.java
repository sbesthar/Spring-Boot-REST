package com.journaldev.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journaldev.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
