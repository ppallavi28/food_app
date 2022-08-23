package com.clarivate.food_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodOrder_id;
	private String order_name;
	
	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Customer customer;

	public int getFoodOrder_id() {
		return foodOrder_id;
	}

	public void setFoodOrder_id(int foodOrder_id) {
		this.foodOrder_id = foodOrder_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
