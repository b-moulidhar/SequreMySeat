package com.valtech.poc.sms.dao;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Manager;

public interface UserDAO {

	Manager getMidByMname(String managerName, Employee emp);
//
//	void saveEmployee(Employee employee, int mId);

//	void saveUser(User user, Employee eId);

	int getRidByRoleName(String role);

	void saveUserRole(int uId, int rId);


	void saveManager(Manager mng);

	int checkIfEmpIdExist(int empId);

	void deleteEmployee(Employee emp);

}