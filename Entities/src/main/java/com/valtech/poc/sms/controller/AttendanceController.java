package com.valtech.poc.sms.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.valtech.poc.sms.entities.AttendanceTable;
import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.repo.AttendanceRepository;
import com.valtech.poc.sms.repo.EmployeeRepo;
import com.valtech.poc.sms.service.AttendanceService;
import com.valtech.poc.sms.service.MailContent;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private MailContent mailContent;

	private final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@ResponseBody
	@PostMapping("/attRegularization")
	public String saveAttendance(@RequestBody AttendanceTable attendance) {
		Employee employee = attendanceService.getSpecificEmployee(attendance);
		// Manager manager = employee.getManagerDetails();
		attendance.seteId(employee);
		attendanceRepository.save(attendance);
		mailContent.attendanceApprovalRequest(attendance);
		return "saved";
	}

	@ResponseBody
	@PostMapping("/attendanceRegularization/{eId}")
	public String saveAttendance(@PathVariable("eId") int eId, @RequestBody AttendanceTable attendance) {
		Employee emp = employeeRepo.findById(eId).get();
		System.out.println(emp.geteId());
		attendanceService.saveAttendance(emp, attendance);
		attendanceRepository.save(attendance);
		mailContent.attendanceApprovalRequest(attendance);
		return "saved";
	}

	@ResponseBody
	@PostMapping("/automaticAttendance/{sbId}")
	public String AutomaticRegularization(@PathVariable("sbId") int sbId) {
		AttendanceTable attendance = new AttendanceTable();
		attendanceService.automaticRegularization(sbId, attendance);
		attendanceRepository.save(attendance);
		mailContent.attendanceApprovalRequest(attendance);
		return "saved";
	}

	@ResponseBody
	@PutMapping("/attendanceApproval/{atId}")
	public String approveAttendance(@PathVariable("atId") int atId) {
		logger.info("Requesting approval");
		String mail = attendanceService.getMailIdByAtId(atId);
		attendanceService.updateAttendance(atId);
		mailContent.attendanceApproved(mail);
		return "approved";

	}

	@ResponseBody
	@DeleteMapping("/disapproveAttendance/{atId}")
	public String deleteAttendanceRequest(@PathVariable("atId") int atId) {
		String mail = attendanceService.getMailIdByAtId(atId);
		attendanceService.deleteAttendanceRequest(atId);
		mailContent.attendanceDisApproved(mail);
		return "disapproved";
	}

	@ResponseBody
	@GetMapping("/attWithManagerDetails/{atId}")
	public AttendanceTable getListWithManagerDetails(@PathVariable("atId") int atId) {
		return attendanceService.getList(atId);
	}

	@ResponseBody
	@GetMapping("/attendanceList")
	public List<Map<String, Object>> getCompleteAttendanceList() {
		return attendanceService.getCompleteAttendanceList();

	}

	@ResponseBody
	@GetMapping("/attendanceByAtId/{atId}")
	public Map<String, Object> getAttendanceEachEmployeeBasedOnAttendanceId(@PathVariable("atId") int atId) {
		try {
			return attendanceService.getAttendanceListForEachEmployee(atId);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendance details not found for id: " + atId);
		}

	}

	@ResponseBody
	@GetMapping("/employeeAttendanceByEId/{eId}")
	public List<Map<String, Object>> getAttendanceForEmployeeBasedOnEmployeeId(@PathVariable("eId") int eId) {
		try {
			return attendanceService.getAttendanceForEmployeeBasedOnEmployeeId(eId);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Attendance details not found for employeeid: " + eId);
		}

	}

	@ResponseBody
	@GetMapping("/attendanceApproval/{eId}")
	public List<Map<String, Object>> getAttendanceListForApproval(@PathVariable("eId") int eId) {
		try {
			return attendanceService.getAttendanceListForApproval(eId);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Attendance details not found for employeeid: " + eId);
		}

	}

}
