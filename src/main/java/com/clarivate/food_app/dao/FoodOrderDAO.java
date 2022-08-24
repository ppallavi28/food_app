package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.Customer;
import com.clarivate.food_app.dto.FoodOrder;
import com.clarivate.food_app.repository.CustomerRepository;
import com.clarivate.food_app.repository.FoodOrderRepository;

@Repository
public class FoodOrderDAO {

	@Autowired
	private FoodOrderRepository repository;

	@Autowired
	private CustomerRepository customerRepository;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder, int id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		foodOrder.setCustomer(customer);
		return repository.save(foodOrder);
	}

	//update
	public FoodOrder updateFoodOrder(FoodOrder foodOrder, int id, int customerId) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			Customer customer = customerRepository.findById(id).orElse(null);
			foodOrder.setCustomer(customer);
			foodOrder.setFoodOrder_id(id);
			return repository.save(foodOrder);
		}
	}

	//delete
	public FoodOrder deleteFoodOrder(int id) {
		FoodOrder foodOrder = getFoodOrderById(id).get();
		repository.delete(foodOrder);
		return foodOrder;
	}

	//Get FoodOrder details by id
	public Optional<FoodOrder> getFoodOrderById(int id) {
		return repository.findById(id);
	}

	//get all FoodOrder details
	public List<FoodOrder> findAllFoodOrder(){
		return repository.findAll();
	}
}
