package com.vksk.Enotes_Api_Service.service;

import java.util.List;

import com.vksk.Enotes_Api_Service.dto.CategoryDto;
import com.vksk.Enotes_Api_Service.dto.CategoryResponse;
import com.vksk.Enotes_Api_Service.entity.Category;

public interface CategoryService {
	
	boolean saveCategory(CategoryDto categoryDto) ;
	
	List<CategoryDto> findAllCategories();

	List<CategoryResponse> findByActiveCategory();

}
