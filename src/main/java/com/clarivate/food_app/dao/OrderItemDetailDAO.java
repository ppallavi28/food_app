package com.clarivate.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.food_app.dto.FoodOrder;
import com.clarivate.food_app.dto.FoodProduct;
import com.clarivate.food_app.dto.OrderItemDetail;
import com.clarivate.food_app.repository.FoodOrderRepository;
import com.clarivate.food_app.repository.FoodPRoductRepository;
import com.clarivate.food_app.repository.OrderItemDetailsRepository;

@Repository
public class OrderItemDetailDAO {

	@Autowired
	private OrderItemDetailsRepository repository;

	@Autowired
	private FoodPRoductRepository foodPRoductRepository;

	@Autowired
	private FoodOrderRepository foodOrderRepository;

	public OrderItemDetail saveOrderItemDetail(OrderItemDetail orderItemDetail, int foodProductId, int foodOrderId) {
		FoodProduct foodProduct = foodPRoductRepository.findById(foodProductId).orElse(null);
		FoodOrder foodOrder = foodOrderRepository.findById(foodOrderId).orElse(null);

		orderItemDetail.setFoodProduct(foodProduct);
		orderItemDetail.setFoodOrder(foodOrder);

		return repository.save(orderItemDetail);
	}

	//update
	public OrderItemDetail updateOrderItemDetail(OrderItemDetail orderItemDetail, int id, int foodProductId, int foodOrderId) {
		if(repository.findById(id).isEmpty()) {
			return null;
		}
		else {
			FoodProduct foodProduct = foodPRoductRepository.findById(foodProductId).orElse(null);
			FoodOrder foodOrder = foodOrderRepository.findById(foodOrderId).orElse(null);

			orderItemDetail.setFoodProduct(foodProduct);
			orderItemDetail.setFoodOrder(foodOrder);
			orderItemDetail.setOrderItem_id(id);
			return repository.save(orderItemDetail);
		}
	}

	//delete
	public OrderItemDetail deleteOrderItemDetail(int id) {
		OrderItemDetail orderItemDetail = getOrderItemDetailById(id).get();
		repository.delete(orderItemDetail);
		return orderItemDetail;
	}

	//Get OrderItemDetail details by id
	public Optional<OrderItemDetail> getOrderItemDetailById(int id) {
		return repository.findById(id);
	}
	
	public String getBill(String bill) {
		return OrderItemDetailsRepository.getBillDetail(bill);
	}

	//get all OrderItemDetail details
	public List<OrderItemDetail> findAllOrderItemDetail(){
		return repository.findAll();
	}
}
