package com.vksk.Enotes_Api_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vksk.Enotes_Api_Service.dto.CategoryDto;
import com.vksk.Enotes_Api_Service.dto.CategoryResponse;
import com.vksk.Enotes_Api_Service.entity.Category;
import com.vksk.Enotes_Api_Service.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
		
		boolean saveCategory = service.saveCategory(categoryDto);
		
		if(saveCategory)
			return new ResponseEntity<>("saved", HttpStatus.OK);
		return new ResponseEntity<>("not saved",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAll(){
		List<CategoryDto> allCategories = service.findAllCategories();
		
		if(CollectionUtils.isEmpty(allCategories)) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}
	
	@GetMapping("/active-cat")
	public ResponseEntity<?> activeCat(){
		List<CategoryResponse> allCategories = service.findByActiveCategory();
		
		if(CollectionUtils.isEmpty(allCategories)) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}
	
	
}
