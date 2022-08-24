package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.BranchManager;
import com.clarivate.food_app.dto.Staff;
import com.clarivate.food_app.repository.BranchManagerRepository;
import com.clarivate.food_app.repository.StaffRepository;

@Repository
public class StaffDAO {

	@Autowired
	private StaffRepository repository;

	@Autowired
	private BranchManagerRepository branchManagerRepository;

	public Staff saveStaff(Staff staff, int id) {
		BranchManager branchManager = branchManagerRepository.findById(id).orElse(null);
		staff.setBranchManager(branchManager);
		return repository.save(staff);
	}
	//update
	public Staff updateStaff(Staff staff, int id, int branchmanagerId) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			BranchManager branchManager = branchManagerRepository.findById(id).orElse(null);
			staff.setBranchManager(branchManager);
			staff.setStaff_id(id);
			return repository.save(staff);
		}
	}

	//delete
	public Staff deleteStaff(int id) {
		Staff staff = getStaffById(id).get();
		repository.delete(staff);
		return staff;
	}

	//Get Staff details by id
	public Optional<Staff> getStaffById(int id) {
		return repository.findById(id);
	}

	//get all Staff details
	public List<Staff> findAllStaff(){
		return repository.findAll();
	}
}
