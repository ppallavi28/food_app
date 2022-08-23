package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.Admin;
import com.clarivate.food_app.repository.AdminRepository;

@Repository
public class AdminDAO {

	@Autowired
	private AdminRepository repository;

	//save
	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}

	//update
	public Admin updateAdmin(Admin admin, int id) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			admin.setAdmin_id(id);
			return repository.save(admin);
		}
	}

	//delete
	public Admin deleteAdmin(int id) {
		Admin admin = getAdminById(id).get();
		repository.delete(admin);
		return admin;
	}

	//Get Admin details by id
	public Optional<Admin> getAdminById(int id) {
		return repository.findById(id);
	}

	//get all Admin details
	public List<Admin> findAllAdmin(){
		return repository.findAll();
	}
}
