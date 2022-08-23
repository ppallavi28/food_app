package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.OrderItemDetailDAO;
import com.clarivate.food_app.dto.OrderItemDetail;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class OrderItemDetailService {

	@Autowired
	OrderItemDetailDAO dao;
	
	public ResponseEntity<ResponseStructure<OrderItemDetail>> saveOrderItemDetail(OrderItemDetail orderItemDetail, int foodProductId, int foodOrderId) {
		ResponseStructure<OrderItemDetail> structure = new ResponseStructure<OrderItemDetail>();
		structure.setMessage("OrderItemDetail saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveOrderItemDetail(orderItemDetail, foodProductId, foodOrderId));
		return new ResponseEntity<ResponseStructure<OrderItemDetail>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<OrderItemDetail>> updateOrderItemDetail(OrderItemDetail orderItemDetail, int id) {
		OrderItemDetail orderItemDetail2 = dao.updateOrderItemDetail(orderItemDetail, id);
		ResponseStructure<OrderItemDetail> structure = new ResponseStructure<OrderItemDetail>();

		if(orderItemDetail2 != null) {
			structure.setMessage("OrderItemDetail updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(orderItemDetail2);
			return  new ResponseEntity<ResponseStructure<OrderItemDetail>>(structure, HttpStatus.OK);
		}
		else {
			structure.setMessage("Invalid Id");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(orderItemDetail2);
			return  new ResponseEntity<ResponseStructure<OrderItemDetail>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<OrderItemDetail>> getOrderItemDetailById(int id){
		Optional<OrderItemDetail> optional = dao.getOrderItemDetailById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			ResponseStructure<OrderItemDetail> structure = new ResponseStructure<OrderItemDetail>();
			structure.setMessage("OrderItemDetail Found successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<OrderItemDetail>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<List<OrderItemDetail>>> findAllOrderItemDetail() {
		ResponseStructure<List<OrderItemDetail>> structure = new ResponseStructure<List<OrderItemDetail>>();
		structure.setMessage("All OrderItemDetail details");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.findAllOrderItemDetail());
		return new ResponseEntity<ResponseStructure<List<OrderItemDetail>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<OrderItemDetail>> deleteOrderItemDetail(int id) {
		ResponseStructure<OrderItemDetail> structure = new ResponseStructure<OrderItemDetail>();
		structure.setMessage("OrderItemDetail deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(dao.deleteOrderItemDetail(id));
		return new ResponseEntity<ResponseStructure<OrderItemDetail>>(structure, HttpStatus.OK);
	}
}
