package com.clarivate.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.food_app.dto.FoodProduct;

public interface FoodPRoductRepository extends JpaRepository<FoodProduct, Integer> {

}
