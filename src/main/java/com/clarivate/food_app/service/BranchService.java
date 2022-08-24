package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.BranchDAO;
import com.clarivate.food_app.dto.Branch;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDAO dao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setMessage("Branch saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveBranch(branch, id));
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int id, int adminId) {
		Branch branch2 = dao.updateBranch(branch, id, adminId);
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

		if(branch2 != null) {
			structure.setMessage("Branch updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(branch2);
			return  new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(branch2);
			return  new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id){
		Optional<Branch> optional = dao.getBranchById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
			structure.setMessage("Branch Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch() {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		structure.setMessage("All Branch details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllBranch());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setMessage("Branch deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteBranch(id));
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
	}

}
