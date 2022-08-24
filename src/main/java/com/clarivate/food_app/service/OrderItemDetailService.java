package com.clarivate.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.clarivate.food_app.dao.FoodOrderDAO;
import com.clarivate.food_app.dao.OrderItemDetailDAO;
import com.clarivate.food_app.dto.Customer;
import com.clarivate.food_app.dto.FoodOrder;
import com.clarivate.food_app.dto.FoodProduct;
import com.clarivate.food_app.dto.OrderItemDetail;
import com.clarivate.food_app.exception.IdNotFoundException;
import com.clarivate.food_app.util.ResponseStructure;

@Service
public class OrderItemDetailService {

	@Autowired
	OrderItemDetailDAO dao;
	
	@Autowired
	FoodOrderDAO foodOrderDAO;
	
	@Autowired 
	private JavaMailSender javaMailSender;
	
	public ResponseEntity<ResponseStructure<OrderItemDetail>> saveOrderItemDetail(OrderItemDetail orderItemDetail, int foodProductId, int foodOrderId) {
		ResponseStructure<OrderItemDetail> structure = new ResponseStructure<OrderItemDetail>();
		structure.setMessage("OrderItemDetail saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(dao.saveOrderItemDetail(orderItemDetail, foodProductId, foodOrderId));
		return new ResponseEntity<ResponseStructure<OrderItemDetail>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<OrderItemDetail>> updateOrderItemDetail(OrderItemDetail orderItemDetail, int id, int foodProductId, int foodOrderId) {
		OrderItemDetail orderItemDetail2 = dao.updateOrderItemDetail(orderItemDetail, id, foodProductId, foodOrderId);
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
	
	public String getBill(int id){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		Optional<FoodOrder> optional = foodOrderDAO.getFoodOrderById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			double amount = 0;
			double gst = 0.09;
			double service = 0.05;
			FoodOrder foodOrder = optional.get();
			Customer customer = foodOrder.getCustomer();
			String customerName = customer.getName();
			
			ResponseEntity<ResponseStructure<List<OrderItemDetail>>> orderItemDetails = findAllOrderItemDetail();
			
			ResponseStructure<List<OrderItemDetail>> list1 = orderItemDetails.getBody();
			
			List<OrderItemDetail> list2 = list1.getT();
			
			for(OrderItemDetail orderItem : list2) {
				FoodOrder foodOrder1 = orderItem.getFoodOrder();
				FoodProduct foodProduct = orderItem.getFoodProduct();
				
				if(foodOrder1.getFoodOrder_id() == id) {
					amount = amount + (orderItem.getItem_quantity() * foodProduct.getPrice());
				}
			}
			double finalamount = (gst * amount)+(service * amount)+amount;
			
			String completeBill = "Food Bill for the customer " + customerName + " is Rs "+amount+" with 9% GST and 5% service, total amount will be Rs "+finalamount;
			
			mailMessage.setFrom("ppallavi099@gmail.com");
            mailMessage.setTo(customer.getEmail());
            mailMessage.setText(completeBill);
            mailMessage.setSubject("Your Food Bill");
            
            javaMailSender.send(mailMessage);
            
			return dao.getBill(completeBill);
		}
	}
}
