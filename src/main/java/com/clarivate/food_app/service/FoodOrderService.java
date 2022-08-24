package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.FoodOrderDAO;
import com.clarivate.food_app.dto.FoodOrder;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDAO dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder, int id) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveFoodOrder(foodOrder, id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id, int customerId) {
		FoodOrder foodOrder2 = dao.updateFoodOrder(foodOrder, id, customerId);
		ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();

		if(foodOrder2 != null) {
			structure.setMessage("FoodOrder updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(foodOrder2);
			return  new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(foodOrder2);
			return  new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id){
		Optional<FoodOrder> optional = dao.getFoodOrderById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
			structure.setMessage("FoodOrder Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<FoodOrder>>> findAllFoodOrder() {
		ResponseStructure<List<FoodOrder>> structure = new ResponseStructure<List<FoodOrder>>();
		structure.setMessage("All FoodOrder details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllFoodOrder());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteFoodOrder(id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
	}
}
