package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.CustomerDAO;
import com.clarivate.food_app.dto.Customer;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO dao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer, int id) {
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		structure.setMessage("Customer saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveCustomer(customer, id));
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer, int id, int staffId) {
		Customer customer2 = dao.updateCustomer(customer, id, staffId);
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();

		if(customer2 != null) {
			structure.setMessage("Customer updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(customer2);
			return  new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(customer2);
			return  new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id){
		Optional<Customer> optional = dao.getCustomerById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
			structure.setMessage("Customer Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
		ResponseStructure<List<Customer>> structure = new ResponseStructure<List<Customer>>();
		structure.setMessage("All Customer details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllCustomer());
		return new ResponseEntity<ResponseStructure<List<Customer>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		structure.setMessage("Customer deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteCustomer(id));
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
	}
}
