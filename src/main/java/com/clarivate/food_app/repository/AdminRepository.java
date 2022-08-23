package com.clarivate.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.food_app.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
