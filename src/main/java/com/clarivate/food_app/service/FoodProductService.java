package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.FoodProductDAO;
import com.clarivate.food_app.dto.FoodProduct;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class FoodProductService {

	@Autowired
	FoodProductDAO dao;

	public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(FoodProduct foodProduct, int id) {
		ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
		structure.setMessage("FoodProduct saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveFoodProduct(foodProduct, id));
		return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodProduct>> updateFoodProduct(FoodProduct foodProduct, int id) {
		FoodProduct foodProduct2 = dao.updateFoodProduct(foodProduct, id);
		ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();

		if(foodProduct2 != null) {
			structure.setMessage("FoodProduct updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(foodProduct2);
			return  new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(foodProduct2);
			return  new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<FoodProduct>> getFoodProductById(int id){
		Optional<FoodProduct> optional = dao.getFoodProductById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
			structure.setMessage("FoodProduct Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct() {
		ResponseStructure<List<FoodProduct>> structure = new ResponseStructure<List<FoodProduct>>();
		structure.setMessage("All FoodProduct details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllFoodProduct());
		return new ResponseEntity<ResponseStructure<List<FoodProduct>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodProduct>> deleteFoodProduct(int id) {
		ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
		structure.setMessage("FoodProduct deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteFoodProduct(id));
		return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
	}
}
