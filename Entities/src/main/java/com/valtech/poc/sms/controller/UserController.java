package com.valtech.poc.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.EmployeeRequest;
import com.valtech.poc.sms.entities.Manager;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.service.ManagerServiceImpl;
import com.valtech.poc.sms.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@ResponseBody
	@PostMapping("/save")
	public String SaveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = employeeRequest.getEmployee();
		User user = employeeRequest.getUser();
		String managerName = employeeRequest.getManagerName();
		String role = employeeRequest.getRole();
		
		Employee emp = new Employee(employee.geteId(), employee.getEmpName(), employee.getPhNum(), employee.getMailId(),
				employee.getManagerDetails());
		userService.saveEmployee(emp, null);
		Manager manager = userService.getManagerByMname(managerName,emp);
		emp.setManagerDetails(manager);
		User newUser = new User(user.getuId(), user.getEmpId(), user.getPass(), emp, false, null, null);
		User u = userService.saveUser(newUser, emp);
		if (u != null) {
			if (role.equals("Manager")) {
				Manager mng = new Manager(emp);
				userService.saveManager(mng);
			}
			int rId = userService.getRidByRoleName(role);
			int uId = newUser.getuId();
			userService.saveUserRoles(uId, rId);
			return "saved all data";
		}
		else {
			userService.deleteEmployee(emp);
			logger.info("User is not created");
			return "user is not created";
		}
		

	}

}
