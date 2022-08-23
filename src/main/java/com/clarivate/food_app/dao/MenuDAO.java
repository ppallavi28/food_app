package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.BranchManager;
import com.clarivate.food_app.dto.Menu;
import com.clarivate.food_app.repository.BranchManagerRepository;
import com.clarivate.food_app.repository.MenuRepository;

@Repository
public class MenuDAO {

	@Autowired
	private MenuRepository repository;

	@Autowired
	private BranchManagerRepository branchManagerRepository;

	public Menu saveMenu(Menu menu, int id) {
		BranchManager branchManager = branchManagerRepository.findById(id).orElse(null);
		menu.setBranchManager(branchManager);
		return repository.save(menu);
	}

	//update
	public Menu updateMenu(Menu menu, int id) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			menu.setMenu_id(id);
			return repository.save(menu);
		}
	}

	//delete
	public Menu deleteMenu(int id) {
		Menu menu = getMenuById(id).get();
		repository.delete(menu);
		return menu;
	}

	//Get Menu details by id
	public Optional<Menu> getMenuById(int id) {
		return repository.findById(id);
	}

	//get all Menu details
	public List<Menu> findAllMenu(){
		return repository.findAll();
	}
}
