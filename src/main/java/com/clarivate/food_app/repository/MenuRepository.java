package com.clarivate.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.food_app.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
