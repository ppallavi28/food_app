package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.Branch;
import com.clarivate.food_app.dto.BranchManager;
import com.clarivate.food_app.repository.BranchManagerRepository;
import com.clarivate.food_app.repository.BranchRepository;

@Repository
public class BranchManagerDAO {

	@Autowired
	private BranchManagerRepository repository;

	@Autowired
	private BranchRepository branchRepository;

	public BranchManager saveBranchManager(BranchManager branchManager, int id) {
		Branch branch = branchRepository.findById(id).orElse(null);
		branchManager.setBranch(branch);
		return repository.save(branchManager);
	}
	//update
	public BranchManager updateBranchManager(BranchManager branchManager, int id) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			branchManager.setBm_id(id);
			return repository.save(branchManager);
		}
	}

	//delete
	public BranchManager deleteBranchManager(int id) {
		BranchManager branchManager = getBranchManagerById(id).get();
		repository.delete(branchManager);
		return branchManager;
	}

	//Get BranchManager details by id
	public Optional<BranchManager> getBranchManagerById(int id) {
		return repository.findById(id);
	}

	//get all BranchManager details
	public List<BranchManager> findAllBranchManager(){
		return repository.findAll();
	}
}
