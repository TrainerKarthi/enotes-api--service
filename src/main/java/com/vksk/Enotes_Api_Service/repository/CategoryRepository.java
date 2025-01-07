package com.vksk.Enotes_Api_Service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vksk.Enotes_Api_Service.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrue();

}
