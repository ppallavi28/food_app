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

import com.clarivate.food_app.dto.OrderItemDetail;
import com.clarivate.food_app.service.OrderItemDetailService;
import com.clarivate.food_app.util.ResponseStructure;

@RestController
@RequestMapping("/api")
public class OrderItemDetailController {

	@Autowired
	OrderItemDetailService service;
	
	@PostMapping("/orderitemdetail/foodproduct/{foodproductId}/foodorder/{foodorderId}")
	public ResponseEntity<ResponseStructure<OrderItemDetail>> saveOrderItemDetail(@RequestBody OrderItemDetail orderItemDetail, @PathVariable(value = "foodproductId") Integer foodproductId, @PathVariable(value = "foodorderId") Integer foodorderId) {
		return service.saveOrderItemDetail(orderItemDetail, foodproductId, foodorderId);
	}
	@PutMapping("/orderitemdetail/foodproduct/{foodproductId}/foodorder/{foodorderId}")
	public ResponseEntity<ResponseStructure<OrderItemDetail>> updateOrderItemDetail(@RequestBody OrderItemDetail orderItemDetail,@RequestParam int id, @PathVariable(value = "foodproductId") Integer foodproductId, @PathVariable(value = "foodorderId") Integer foodorderId) {
		return service.updateOrderItemDetail(orderItemDetail,id, foodproductId, foodorderId);
	}
	
	@DeleteMapping("/orderitemdetail")
	public ResponseEntity<ResponseStructure<OrderItemDetail>>  deleteOrderItemDetail(@RequestParam int id) {
		return service.deleteOrderItemDetail(id);
	}
	
	@GetMapping("/orderitemdetail/{id}")
	public ResponseEntity<ResponseStructure<OrderItemDetail>>  getOrderItemDetailById(@PathVariable int id) {
		return service.getOrderItemDetailById(id);
	}
	
	@GetMapping("/getBill/{foodorderid}")
	public String  getBill(@PathVariable int foodorderid) {
		return service.getBill(foodorderid);
	}
	
	@GetMapping("/orderitemdetail")
	public ResponseEntity<ResponseStructure<List<OrderItemDetail>>> findAllOrderItemDetail(){
		return service.findAllOrderItemDetail();
	}
}
