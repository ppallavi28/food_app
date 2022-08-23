package com.clarivate.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.food_app.dto.Staff;
import com.clarivate.food_app.service.StaffService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
public class StaffController {

	@Autowired
	StaffService service;
	
	@PostMapping("/savestaff/{branchmanagerId}")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff, @PathVariable(value = "branchmanagerId") Integer branchmanagerId) {
		return service.saveStaff(staff, branchmanagerId);
	}
	@PutMapping("/updateStaff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff Staff,@RequestParam int id) {
		return service.updateStaff(Staff,id);
	}
	
	@DeleteMapping("/deleteStaff")
	public ResponseEntity<ResponseStructure<Staff>>  deleteStaff(@RequestParam int id) {
		return service.deleteStaff(id);
	}
	
	@GetMapping("/getStaffbyid/{id}")
	public ResponseEntity<ResponseStructure<Staff>>  getStaffById(@PathVariable int id) {
		return service.getStaffById(id);
	}
	
	@GetMapping("/findallStaff")
	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff(){
		return service.findAllStaff();
	}
}
