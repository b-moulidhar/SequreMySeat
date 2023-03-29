package com.valtech.poc.sms.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.EmployeeRequest;
import com.valtech.poc.sms.entities.Manager;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.security.JwtUtil;
import com.valtech.poc.sms.service.UserService;

@RestController
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

@Autowired
private JwtUtil jwtUtil;
    
    

	@PostMapping("/api/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
		String empId = request.get("empId");
		String pass = request.get("pass");

		String token = userService.login(Integer.parseInt(empId), pass);

		Map<String, String> response = new HashMap<>();
		response.put("token", token);

		return ResponseEntity.ok(response);
	}


	@GetMapping("/user")
	public ResponseEntity<User> getUser(@RequestHeader("Authorization") String token) {
		int username = jwtUtil.extractEmpId(token);
		User user = userService.findByEmpId(username);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/my-protected-endpoint")
	public String myProtectedEndpoint() {
		// logic for your protected API endpoint here
		return "Hello, this is a protected endpoint!";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		String text = "this is private page";
		text+="this page is not allowed to unauthenticated users";
		return text;

	}
	@PutMapping("/{empId}")
    public String updateUserApproval(@PathVariable("empId") int empId) {
        User user = userService.findByEmpId(empId);
        boolean approval=true;
        if (user == null) {
            return "User not found";
        }
        user.setApproval(approval);
        userService.save(user);
        return  "User saved successfully";
    }

	


}
