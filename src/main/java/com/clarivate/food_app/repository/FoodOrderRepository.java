package com.clarivate.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.food_app.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}
