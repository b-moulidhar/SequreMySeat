package com.valtech.poc.sms.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.valtech.poc.sms.entities.AttendanceTable;
import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.SeatsBooked;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.AttendanceRepository;
import com.valtech.poc.sms.repo.SeatsBookedRepo;
import com.valtech.poc.sms.repo.UserRepo;
import com.valtech.poc.sms.service.AdminService;
import com.valtech.poc.sms.service.EmployeeService;
import com.valtech.poc.sms.service.MailContent;
import com.valtech.poc.sms.service.SeatBookingService;
import com.valtech.poc.sms.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private MailContent mailContent;

	@Autowired
	SeatBookingService seatBookingService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	UserService userService;

	private final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@ResponseBody
	@GetMapping("/foodCount/{ftDate}")
	public int getFoodCount(@PathVariable("ftDate") String ftDate) {
		logger.info("Fetching the food count");
		int count = adminService.getFoodCount(ftDate);
		return count;
	}

	@Autowired
	SeatsBookedRepo seatsBookedRepo;

	@ResponseBody
	@GetMapping("/checkout")
	public String checkOut(@RequestParam("empId") int empId) {
		User usr = userService.findByEmpId(empId);
		Employee emp = usr.getEmpDetails();
		SeatsBooked sb = seatBookingService.findCurrentSeatBookingDetails(emp);
		System.out.println("sb details: " + sb.getPunchIn());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(formatter.format(now), formatter);
//		LocalDateTime dateTime = formatter.format(now);
		sb.setPunchOut(dateTime);
		seatsBookedRepo.save(sb);
		return "test";
	}

	@ResponseBody
	@GetMapping("/viewPass/{eId}")
	public String viewPasscode(@PathVariable("eId") int eId) {
//		User usr = userService.findByEId(eId);
//		Employee emp = usr.getEmpDetails();
		Employee emp = employeeService.findById(eId);
		System.out.println(emp.getEmpName());
		SeatsBooked sb = seatBookingService.findCurrentSeatBookingDetails(emp);
		String code = sb.getCode();
		System.out.println(code);
		return code;
	}

	@ResponseBody
	@GetMapping("/qr/codeGenerator/{empId}")
	public String getCodeForQrGeneration(@PathVariable("empId") int empId) {
		// call function which returns "code" from seat_booked table based on current
		// status for this empId
		String qrCodeKey = adminService.generateQrCode(empId);// this generates new code everytime (for test purpose
																// only)
		return qrCodeKey;
	}

	@ResponseBody
	@GetMapping("/foodCountWithJpa/{ftDate}")
	public int getCountByFtdate(@PathVariable("ftDate") String ftDate) {
		return adminService.getCount(ftDate);
	}

	@ResponseBody
	@GetMapping("/seatCount/{sbStartDate}")
	public int getCountBySbDate(@PathVariable("sbStartDate") String sbStartDate) {
		logger.info("Fetching the seat booked count");
		int count = adminService.getSeatBookedCount(sbStartDate);
		return count;

	}

	@ResponseBody
	@GetMapping("/shiftStart")
	public List<String> findShiftStartTimings() {
		logger.info("fetching all the shift start timings");
		return adminService.findShiftStartTimings();
	}

	@ResponseBody
	@GetMapping("/shiftEnd")
	public List<String> findShiftEndTimings() {
		logger.info("fetching all the shift end timings");
		return adminService.findShiftEndTimings();
	}

	@ResponseBody
	@GetMapping("/roleNames")
	public List<String> findRoles() {
		logger.info("fetching all the roles");
		return adminService.findRoles();
	}

	@ResponseBody
	@GetMapping("/registrationApprovalList")
	public List<Map<String, Object>> getRegistrationListForApproval() {
		logger.info("fetching the list of approval requests");
		return adminService.getRegistrationListForApproval();

	}

	@ResponseBody
	@PostMapping("/attendanceRegularization")
	public String saveAttendance(@RequestBody AttendanceTable attendance) {
		Employee employee = adminService.getSpecificEmploye(attendance);
		// Manager manager = employee.getManagerDetails();
		attendance.seteId(employee);
		attendanceRepository.save(attendance);
		mailContent.attendanceApprovalRequest(attendance);
		return "saved";
	}

	@ResponseBody
	@PutMapping("/attendanceApproval/{atId}")
	public String approveAttendance(@PathVariable("atId") int atId) {
		logger.info("Requesting approval");
		adminService.updateAttendance(atId);
		return "approved";

	}

	@ResponseBody
	@PostMapping("/automaticAttendance/{sbId}")
	public String AutomaticRegularization(@PathVariable("sbId") int sbId) {
		AttendanceTable attendance = new AttendanceTable();
		adminService.automaticRegularization(sbId, attendance);
		attendanceRepository.save(attendance);
		mailContent.attendanceApprovalRequest(attendance);
		return "saved";
	}

	@DeleteMapping("/disapproveAttendance/{atId}")
	public void deleteAttendanceRequest(@PathVariable("atId") int atId) {
		adminService.deleteAttendanceRequest(atId);
	}

	@ResponseBody
	@GetMapping("/att/{atId}")
	public AttendanceTable getListWithManagerDetails(@PathVariable("atId") int atId) {
		return adminService.getList(atId);
	}

	@ResponseBody
	@GetMapping("/attendance")
	public List<Map<String, Object>> getCompleteAttendanceList() {
		return adminService.getCompleteAttendanceList();

	}

	@ResponseBody
	@GetMapping("/attendance/{atId}")
	public Map<String, Object> getAttendanceEachEmployeeBasedOnAttendanceId(@PathVariable("atId") int atId) {
		try {
			return adminService.getAttendanceListForEachEmployee(atId);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendance details not found for id: " + atId);
		}

	}

	@ResponseBody
	@GetMapping("/employeeAttendance/{eId}")
	public List<Map<String, Object>> getAttendanceForEmployeeBasedOnEmployeeId(@PathVariable("eId") int eId) {
		try {
			return adminService.getAttendanceForEmployeeBasedOnEmployeeId(eId);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Attendance details not found for employeeid: " + eId);
		}

	}

	@ResponseBody
	@GetMapping("/attendanceApproval/{eId}")
	public List<Map<String, Object>> getAttendanceListForApproval(@PathVariable("eId") int eId) {
		try {
			return adminService.getAttendanceListForApproval(eId);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Attendance details not found for employeeid: " + eId);
		}

	}

	@GetMapping("/{eId}")
	public Employee getEmployeeById(@PathVariable int eId) {
		return employeeService.getEmployeeByeId(eId);
	}

    @Autowired
    private UserRepo userRepo;
    
    @ResponseBody
    @PutMapping("/regestrationApproval/{empId}")
    public String RegestrationApproval(@PathVariable("empId") int empId) {
    	User u=userRepo.findByEmpId(empId);
    	if(u.isApproval()==false) {
    		adminService.ApproveRegistration(u.getuId());
    		return "Approved";
    	}
    	else {
    		return "The User is Already Approved";
    	}
    }
  
  @ResponseBody
  @DeleteMapping("/regestrationDisapproval/{empId}")
  public String RegestrationDisApproval(@PathVariable("empId") int empId) {
	adminService.deleteUser(empId);
	return "DisApproved";
	  
  }
 
}