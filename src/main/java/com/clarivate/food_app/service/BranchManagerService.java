package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.BranchManagerDAO;
import com.clarivate.food_app.dto.BranchManager;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.AES;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class BranchManagerService {

	@Autowired
	BranchManagerDAO dao;
	
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(BranchManager branchManager, int id) {
		String passwordEncrypt = AES.encrypt(branchManager.getPassword(), "pass");
		branchManager.setPassword(passwordEncrypt);
		ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
		structure.setMessage("BranchManager saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveBranchManager(branchManager, id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(BranchManager branchManager, int id, int branchId) {
		String passwordEncrypt = AES.encrypt(branchManager.getPassword(), "pass");
		branchManager.setPassword(passwordEncrypt);
		BranchManager branchManager2 = dao.updateBranchManager(branchManager, id, branchId);
		
		ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();

		if(branchManager2 != null) {
			
			structure.setMessage("BranchManager updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(branchManager2);
			return  new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(branchManager2);
			return  new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(int id){
		Optional<BranchManager> optional = dao.getBranchManagerById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
			structure.setMessage("BranchManager Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager() {
		ResponseStructure<List<BranchManager>> structure = new ResponseStructure<List<BranchManager>>();
		structure.setMessage("All BranchManager details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllBranchManager());
		return new ResponseEntity<ResponseStructure<List<BranchManager>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(int id) {
		ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
		structure.setMessage("BranchManager deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteBranchManager(id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
	}
}
