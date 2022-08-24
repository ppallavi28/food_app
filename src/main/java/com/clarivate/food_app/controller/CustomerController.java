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

import com.clarivate.food_app.dto.Customer;
import com.clarivate.food_app.service.CustomerService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@PostMapping("/savecustomer/{staffId}")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer, @PathVariable(value = "staffId") Integer staffId) {
		return service.saveCustomer(customer, staffId);
	}
	@PutMapping("/updateCustomer/{staffId}")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer,@RequestParam int id, @PathVariable(value = "staffId") Integer staffId) {
		return service.updateCustomer(customer,id, staffId);
	}
	
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<ResponseStructure<Customer>>  deleteCustomer(@RequestParam int id) {
		return service.deleteCustomer(id);
	}
	
	@GetMapping("/getCustomerbyid/{id}")
	public ResponseEntity<ResponseStructure<Customer>>  getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}
	
	@GetMapping("/findallCustomer")
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer(){
		return service.findAllCustomer();
	}
}
