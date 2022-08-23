package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.Admin;
import com.clarivate.food_app.dto.Branch;
import com.clarivate.food_app.repository.AdminRepository;
import com.clarivate.food_app.repository.BranchRepository;

@Repository
public class BranchDAO {

	@Autowired
	private BranchRepository repository;

	@Autowired
	private AdminRepository adminRepository;

	public Branch saveBranch(Branch branch, int id) {
		Admin admin = adminRepository.findById(id).orElse(null);
		branch.setAdmin(admin);
		return repository.save(branch);
	}

	//update
	public Branch updateBranch(Branch branch, int id) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			branch.setBranch_id(id);
			return repository.save(branch);
		}
	}

	//delete
	public Branch deleteBranch(int id) {
		Branch branch = getBranchById(id).get();
		repository.delete(branch);
		return branch;
	}

	//Get Branch details by id
	public Optional<Branch> getBranchById(int id) {
		return repository.findById(id);
	}

	//get all Branch details
	public List<Branch> findAllBranch(){
		return repository.findAll();
	}
}
