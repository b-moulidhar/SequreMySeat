package com.valtech.poc.sms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.dao.UserDAO;
import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Manager;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.EmployeeRepo;
import com.valtech.poc.sms.repo.ManagerRepo;
import com.valtech.poc.sms.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userepo;

	@Autowired
	private UserDAO userDAO;

	@Autowired
//	EmployeeRepo employeeRepo;
	EmployeeRepo empRepo;

	@Autowired
	ManagerRepo managerRepo;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User findByEmail(String email) {
		Employee emp = empRepo.findByMailId(email);
		User usr = userepo.findByEmpDetails(emp);
		System.out.println("usr= " + usr);
		return usr;
	}

	@Override
	public Manager getManagerByMname(String managerName, Employee emp) throws EmptyResultDataAccessException {
		try {
			logger.info("fetching manager ");

			Manager mng = userDAO.getMidByMname(managerName, emp);
//		logger.info("" + mng.getmId());
//			if (mng != null)
				return mng;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manager Not Found");
			
		}
		return null;
		
	}

	@Override
	public void saveEmployee(Employee employee, Manager manager) {
		logger.info("Saving Employee info");
//		userDAO.saveEmployee(employee,mId);
		if (manager != null) {
			employee.setManagerDetails(manager);
			logger.info("assigning manger ");
		} else {
			employee.setManagerDetails(null);
		}
		empRepo.save(employee);
		logger.info("saved: " + employee);
	}

	@Override
	public User saveUser(User user, Employee emp) throws EmptyResultDataAccessException {
		try {
			logger.info("Saving User Info");

			if (checkIfEmpIdExist(user.getEmpId())) {
				User u = userepo.save(user);
				u.setEmpDetails(emp);
				return u;
			}
		} catch (Exception e) {
			logger.info("The EmpId is already exist");
		}

		return null;

	}

	public boolean checkIfEmpIdExist(int empId) throws EmptyResultDataAccessException{
		try {
		logger.info("checking if EmpId Is already Exist or not");
		int rows = userDAO.checkIfEmpIdExist(empId);
		if (rows != 0)
			return false;
		
	}catch (Exception e) {
		logger.info("No empId");
	}
		return true;
	}

	@Override
	public int getRidByRoleName(String role) {
		logger.info("Getting role_id by using name of the role");
		return userDAO.getRidByRoleName(role);
	}

	@Override
	public void saveUserRoles(int uId, int rId) {
		logger.info("Saving the User_roles");
		userDAO.saveUserRole(uId, rId);
	}

	@Override
	public void saveManager(Manager mng) {
		logger.info("Saving Manager");
		managerRepo.save(mng);
	}
//
//	@Override
//	public int getMidByName(String managerName) {
//		int mId = userDAO.getMidByMname(managerName);
//		return mId;
//	}

	@Override
	public void deleteEmployee(Employee emp) {
		userDAO.deleteEmployee(emp);
	}

//	@Override
//	public void saveEmployee(Employee employee, int mid) {
//		// TODO Auto-generated method stub
//		userDAO.saveEmployee(employee, mid);
//	}

}
