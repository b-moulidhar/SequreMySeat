package com.valtech.poc.sms.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.poc.sms.dao.ManagerDAO;
import com.valtech.poc.sms.entities.User;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO managerDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Override
	public User getManagerByEmpId(int empId) {
		logger.info("Fething the manager data using the empId of manager");
		System.out.println(managerDAO.getManagerByEmpId(empId));
		return managerDAO.getManagerByEmpId(empId);
	}
}
