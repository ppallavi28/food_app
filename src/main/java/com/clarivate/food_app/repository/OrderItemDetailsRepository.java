
package com.clarivate.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.food_app.dto.OrderItemDetail;

public interface OrderItemDetailsRepository extends JpaRepository<OrderItemDetail, Integer> {

	static String getBillDetail(String bill) {
		return bill;
	}
}
