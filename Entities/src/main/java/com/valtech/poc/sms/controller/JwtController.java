//package com.valtech.poc.sms.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.valtech.poc.sms.model.JwtRequest;
//import com.valtech.poc.sms.model.JwtResponse;
//import com.valtech.poc.sms.security.JwtUtil;
//
//@RestController
//public class JwtController {
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@PostMapping("/api/login")
//	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
//		
//		System.out.println(jwtRequest);
//		try {
//			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmpId(), jwtRequest.getPass()));
//		}catch (UsernameNotFoundException e) {
//			e.printStackTrace();
//			throw new Exception("Bad Credentials");
//		}catch (BadCredentialsException e) {
//			e.printStackTrace();
//			throw new Exception("Bad Credentials");
//			}
//		
//		UserDetails userDetails=this.userDetailsService.loadUserByUsername(String.valueOf(jwtRequest.getEmpId()));
//		
//		String token = this.jwtUtil.generateToken(userDetails);	
//		System.out.println("JWT "+token);
//		
//		return ResponseEntity.ok(new JwtResponse(token));
//		
//	}
//
//}
