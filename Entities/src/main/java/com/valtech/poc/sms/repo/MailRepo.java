package com.valtech.poc.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.poc.sms.entities.Employee;

@Repository
public interface MailRepo extends JpaRepository<Employee, Integer>{

	Employee findByEmpName(String empName);
}
