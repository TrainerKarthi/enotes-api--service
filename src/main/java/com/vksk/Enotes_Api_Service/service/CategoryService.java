package com.vksk.Enotes_Api_Service.service;

import java.util.List;

import com.vksk.Enotes_Api_Service.entity.Category;

public interface CategoryService {
	
	boolean saveCategory(Category category) ;
	
	List<Category> findAllCategories();

}
