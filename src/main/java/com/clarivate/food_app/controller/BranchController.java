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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.food_app.dto.Branch;
import com.clarivate.food_app.service.BranchService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	BranchService service;
	
	@PostMapping("/branch/{adminId}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @PathVariable(value = "adminId") Integer adminId) {
		return service.saveBranch(branch, adminId);
	}
	
	@PutMapping("/Branch/{adminId}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@RequestParam int id,  @PathVariable(value = "adminId") Integer adminId) {
		return service.updateBranch(branch,id, adminId);
	}
	
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>>  deleteBranch(@RequestParam int id) {
		return service.deleteBranch(id);
	}
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>>  getBranchById(@PathVariable int id) {
		return service.getBranchById(id);
	}
	
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch(){
		return service.findAllBranch();
	}
}
