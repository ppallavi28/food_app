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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.food_app.dto.FoodProduct;
import com.clarivate.food_app.service.FoodProductService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
public class FoodProductController {

	@Autowired
	FoodProductService service;
	
	@PostMapping("/savefoodproduct/{menuId}")
	public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(@RequestBody FoodProduct foodProduct, @PathVariable(value = "menuId") Integer menuId) {
		return service.saveFoodProduct(foodProduct, menuId);
	}
	@PutMapping("/updateFoodProduct/{menuId}")
	public ResponseEntity<ResponseStructure<FoodProduct>> updateFoodProduct(@RequestBody FoodProduct foodProduct,@RequestParam int id, @PathVariable(value = "menuId") Integer menuId) {
		return service.updateFoodProduct(foodProduct,id, menuId);
	}
	
	@DeleteMapping("/deleteFoodProduct")
	public ResponseEntity<ResponseStructure<FoodProduct>>  deleteFoodProduct(@RequestParam int id) {
		return service.deleteFoodProduct(id);
	}
	
	@GetMapping("/getFoodProductbyid/{id}")
	public ResponseEntity<ResponseStructure<FoodProduct>>  getFoodProductById(@PathVariable int id) {
		return service.getFoodProductById(id);
	}
	
	@GetMapping("/findallFoodProduct")
	public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct(){
		return service.findAllFoodProduct();
	}
}
