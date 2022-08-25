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

import com.clarivate.food_app.dto.Menu;
import com.clarivate.food_app.service.MenuService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
@RequestMapping("/api")
public class MenuController {

	@Autowired
	MenuService service;
	
	@PostMapping("/menu/{branchManagerId}")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu, @PathVariable(value = "branchManagerId") Integer branchManagerId) {
		return service.saveMenu(menu, branchManagerId);
	}
	@PutMapping("/menu/{branchManagerId}")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu,@RequestParam int id, @PathVariable(value = "branchManagerId") Integer branchManagerId) {
		return service.updateMenu(menu,id, branchManagerId);
	}
	
	@DeleteMapping("/menu")
	public ResponseEntity<ResponseStructure<Menu>>  deleteMenu(@RequestParam int id) {
		return service.deleteMenu(id);
	}
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<ResponseStructure<Menu>>  getMenuById(@PathVariable int id) {
		return service.getMenuById(id);
	}
	
	@GetMapping("/menu")
	public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu(){
		return service.findAllMenu();
	}
}
