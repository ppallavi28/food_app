package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.Customer;
import com.clarivate.food_app.dto.Staff;
import com.clarivate.food_app.repository.CustomerRepository;
import com.clarivate.food_app.repository.StaffRepository;

@Repository
public class CustomerDAO {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private StaffRepository staffRepository;

	public Customer saveCustomer(Customer customer, int id) {
		Staff staff = staffRepository.findById(id).orElse(null);
		customer.setStaff(staff);
		return repository.save(customer);
	}

	//update
	public Customer updateCustomer(Customer customer, int id, int staffId) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			Staff staff = staffRepository.findById(staffId).orElse(null);
			customer.setStaff(staff);
			customer.setId(id);
			return repository.save(customer);
		}
	}

	//delete
	public Customer deleteCustomer(int id) {
		Customer customer = getCustomerById(id).get();
		repository.delete(customer);
		return customer;
	}

	//Get Customer details by id
	public Optional<Customer> getCustomerById(int id) {
		return repository.findById(id);
	}

	//get all Customer details
	public List<Customer> findAllCustomer(){
		return repository.findAll();
	}
}
