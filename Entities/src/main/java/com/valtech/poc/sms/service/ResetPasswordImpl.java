package com.valtech.poc.sms.service;

import java.util.List;
import java.util.Random;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.entities.Otp;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.OtpRepo;
import com.valtech.poc.sms.repo.UserepoTemp;

@Service
public class ResetPasswordImpl {

	@Autowired
	UserepoTemp userRepo;

	@Autowired
	UserServiceTempImpl userServiceTempImpl;

	@Autowired
	OtpRepo otpRepo;

//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;

	public boolean checkMailId(String email) {
		List<User> allUsers = userRepo.findAll();
		for (User user1 : allUsers) {
			if (email.equals(user1.getEmpDetails().getMailId())) {
				return true;
			}
		}
		return false;
	}

	public String getRandomNumberString() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		return String.format("%06d", number);
	}

	public boolean generateOtp(String email) {
		User usr = userServiceTempImpl.findByEmail(email);
		String otpKey = getRandomNumberString();
		Otp otp = new Otp(otpKey);
		System.out.println("otp1= " + otpKey);
		otpRepo.save(otp);
//		mailMessage.sendOTP(usr.getEmail(), otp1);
//		String Pass = bCryptPasswordEncoder.encode(otpKey);
//		usr.setPass(Pass);
		usr.setOtp(otp);
		userRepo.save(usr);
//		ResponseEntity<UserDetails> user1= userfacade.saveUser(usr);
		System.out.println(usr);
		return true;
	}

	public boolean newPasswod(String email, String otpKey, String password) {
		User usr = userServiceTempImpl.findByEmail(email);
		String key = usr.getOtp().getOtpKey();
//		System.out.println("key = "+key);
//		System.out.println("otpKey= "+otpKey);
		if (otpKey.equals(key)) {
			usr.setPass(password);
			userRepo.save(usr);
			return true;
		}
		return false;
	}
//	
//	public boolean checkpassword(int id,String password) {
//		return userfacade.checkpassword(id, password);
//	}
//	
//	public void changepassword(int id,String password) {
//		UserDetails usr= userfacade.findById(id);
//		usr.setPassword(password);
//		userfacade.saveUser(usr);
//	}
//	
//	public int getidbyemail(String email) {
//		UserDetails user = userfacade.getbyemail(email);
//		return user.getId();
//	}
//	
//	public UserDetails getuserdetailsbyid(int id) {
//		System.out.println("===================================");
//		return userfacade.findById(id);
//	}
//	
//	public List<UserDetails> getalluser() {
//		return userfacade.getuser();
//	}
//	
//	public UserDetails getuserbynurse(NurseDetails nurse) {
//		return userfacade.findByNurseDetails(nurse);
//	}

//	bCryptPasswordEncoder.matches(password, u.getPassword())

//	public String savedoctor(user_details user) {
//		int flag=0;
//		List<user_details> users= userrepo.findAll();
//		for(user_details user1:users) {
//			if(user1.getEmail().equals(user.getEmail())) {
//				flag=1;
//			}
//		}
//		if(flag==1) {
//			return "not";
//		}
//		  Doctor_details d = user.getDoctordetails();
//		  d.setApproval(false);
//		  d.setAvaliability(true);
//		  Doctor_details d1 = doctorservice.savedoctor(d);
//		  user_details u = new user_details(user.getEmail(), user.getPassword(), d1);
//		  userrepo.save(u);
//		  return "saved";
//	}

}
