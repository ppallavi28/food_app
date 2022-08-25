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

import com.clarivate.food_app.dto.BranchManager;
import com.clarivate.food_app.service.BranchManagerService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
@RequestMapping("/api")
public class BranchManagerController {

	@Autowired
	BranchManagerService service;
	
	@PostMapping("/branchmanager/{branchId}")
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@RequestBody BranchManager branchManager, @PathVariable(value = "branchId") Integer branchId) {
		return service.saveBranchManager(branchManager, branchId);
	}
	
	@PutMapping("/branchmanager/{branchId}")
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(@RequestBody BranchManager branchManager,@RequestParam int id, @PathVariable(value = "branchId") Integer branchId) {
		return service.updateBranchManager(branchManager,id, branchId);
	}
	
	@DeleteMapping("/branchmanager")
	public ResponseEntity<ResponseStructure<BranchManager>>  deleteBranchManager(@RequestParam int id) {
		return service.deleteBranchManager(id);
	}
	
	@GetMapping("/branchmanager/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>>  getBranchManagerById(@PathVariable int id) {
		return service.getBranchManagerById(id);
	}
	
	@GetMapping("/branchmanager")
	public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManager(){
		return service.findAllBranchManager();
	}
}
