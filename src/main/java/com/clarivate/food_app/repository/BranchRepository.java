package com.clarivate.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.food_app.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
