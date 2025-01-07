package com.vksk.Enotes_Api_Service.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.vksk.Enotes_Api_Service.entity.Category;
import com.vksk.Enotes_Api_Service.repository.CategoryRepository;
import com.vksk.Enotes_Api_Service.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;

	@Override
	public boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category category2 = repo.save(category);

		return !ObjectUtils.isEmpty(category2);
	}

	@Override
	public List<Category> findAllCategories() {

		List<Category> allCategories = repo.findAll();

		return allCategories;
	}

}
