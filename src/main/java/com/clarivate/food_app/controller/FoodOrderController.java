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

import com.clarivate.food_app.dto.FoodOrder;
import com.clarivate.food_app.service.FoodOrderService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
@RequestMapping("/api")
public class FoodOrderController {

	@Autowired
	FoodOrderService service;
	
	@PostMapping("/foodorder/{customerId}")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodorder(@RequestBody FoodOrder foodOrder, @PathVariable(value = "customerId") Integer customerId) {
		return service.saveFoodOrder(foodOrder, customerId);
	}
	@PutMapping("/foodorder/{customerId}")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id, @PathVariable(value = "customerId") Integer customerId) {
		return service.updateFoodOrder(foodOrder,id, customerId);
	}
	
	@DeleteMapping("/foodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>>  deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}
	
	@GetMapping("/foodorder/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>>  getFoodOrderById(@PathVariable int id) {
		return service.getFoodOrderById(id);
	}
	
	@GetMapping("/foodorder")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder(){
		return service.findAllFoodOrder();
	}
	
}
