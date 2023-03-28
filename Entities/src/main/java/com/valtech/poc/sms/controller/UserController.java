package com.valtech.poc.sms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.security.JwtUtil;
import com.valtech.poc.sms.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
@Autowired
private JwtUtil jwtUtil;
    
    
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String empId = request.get("empId");
        String pass = request.get("pass");

        String token = userService.login(Integer.parseInt(empId), pass);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
//        String empId = request.get("empId");
//        String pass = request.get("pass");
//
//        String token = userService.login(Integer.parseInt(empId), pass);
//
//        return ResponseEntity.ok(token);
//    }
    
//    @Autowired
//    private JwtUtil jwtUtil;
//
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
   
   

}
