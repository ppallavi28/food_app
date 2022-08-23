package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.FoodProduct;
import com.clarivate.food_app.dto.Menu;
import com.clarivate.food_app.repository.FoodPRoductRepository;
import com.clarivate.food_app.repository.MenuRepository;


@Repository
public class FoodProductDAO {

	@Autowired
	private FoodPRoductRepository repository;

	@Autowired
	private MenuRepository menuRepository;

	public FoodProduct saveFoodProduct(FoodProduct foodProduct, int id) {
		Menu menu = menuRepository.findById(id).orElse(null);
		foodProduct.setMenu(menu);
		return repository.save(foodProduct);
	}
	//update
	public FoodProduct updateFoodProduct(FoodProduct foodProduct, int id) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			foodProduct.setFood_id(id);
			return repository.save(foodProduct);
		}
	}

	//delete
	public FoodProduct deleteFoodProduct(int id) {
		FoodProduct foodProduct = getFoodProductById(id).get();
		repository.delete(foodProduct);
		return foodProduct;
	}

	//Get FoodProduct details by id
	public Optional<FoodProduct> getFoodProductById(int id) {
		return repository.findById(id);
	}

	//get all FoodProduct details
	public List<FoodProduct> findAllFoodProduct(){
		return repository.findAll();
	}
}
