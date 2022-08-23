package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.StaffDAO;
import com.clarivate.food_app.dto.Staff;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.AES;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class StaffService {

	@Autowired
	StaffDAO dao;

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff, int id) {
		String passwordEncrypt = AES.encrypt(staff.getPassword(), "pass");
		staff.setPassword(passwordEncrypt);
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		structure.setMessage("Staff saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveStaff(staff, id));
		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff, int id) {
		Staff staff2 = dao.updateStaff(staff, id);
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();

		if(staff2 != null) {
			structure.setMessage("Staff updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(staff2);
			return  new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(staff2);
			return  new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(int id){
		Optional<Staff> optional = dao.getStaffById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
			structure.setMessage("Staff Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaff() {
		ResponseStructure<List<Staff>> structure = new ResponseStructure<List<Staff>>();
		structure.setMessage("All Staff details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllStaff());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int id) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		structure.setMessage("Staff deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteStaff(id));
		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
	}
}
