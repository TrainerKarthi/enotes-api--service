package com.vksk.Enotes_Api_Service.service;

import java.util.List;

import com.vksk.Enotes_Api_Service.dto.CategoryDto;
import com.vksk.Enotes_Api_Service.dto.CategoryResponse;

public interface CategoryService {

	boolean saveCategory(CategoryDto categoryDto);

	List<CategoryDto> findNotDeletedCategories();

	List<CategoryResponse> findByActiveAndNotDeletedCategory();

	CategoryDto findByCategoryIdAndNotDeleted(int id);

	boolean deleteById(int id);

}
