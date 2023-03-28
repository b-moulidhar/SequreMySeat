package com.valtech.poc.sms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.EmployeeRequest;
import com.valtech.poc.sms.entities.Manager;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@PostMapping("/save")
	public String SaveEmployee(@RequestBody EmployeeRequest employeeRequest) {
	    Employee employee = employeeRequest.getEmployee();
	    User user = employeeRequest.getUser();
	    String managerName = employeeRequest.getManagerName();
	    String role = employeeRequest.getRole();
//	    int mid=userService.getMidByName(managerName);
	    Manager manager=userService.getManagerByMname(managerName);
//	    Employee emp = new Employee(employee.geteId(),employee.getEmpName(), employee.getPhNum(), employee.getMailId(), employee.getManagerDetails());
//	    userService.saveEmployee(employee,mid);
	    userService.saveEmployee(employee,manager);
	    
//		int eId=employee.geteId();
	
		User newUser=new User(user.getuId(),user.getEmpId(),user.getPass(), employee, false, null, null);
		userService.saveUser(newUser,employee);
		if(role.equals("Manager")) {
			Manager mng = new Manager(employee);
//			managerRepo.save(mng);
			userService.saveManager(mng);
		}
		int rId=userService.getRidByRoleName(role);
		int uId=user.getuId();
		userService.saveUserRoles(uId,rId);
		return "saved all data";
	  
	}


}
