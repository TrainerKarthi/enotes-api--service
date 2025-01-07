package com.vksk.Enotes_Api_Service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.vksk.Enotes_Api_Service.dto.CategoryDto;
import com.vksk.Enotes_Api_Service.dto.CategoryResponse;
import com.vksk.Enotes_Api_Service.entity.Category;
import com.vksk.Enotes_Api_Service.repository.CategoryRepository;
import com.vksk.Enotes_Api_Service.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean saveCategory(CategoryDto categoryDto) {

//		Category category = new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());

		Category category = mapper.map(categoryDto, Category.class);

		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());

		Category category2 = repo.save(category);

		return !ObjectUtils.isEmpty(category2);
	}

	@Override
	public List<CategoryDto> findAllCategories() {

		List<Category> allCategories = repo.findAll();

		List<CategoryDto> list = new ArrayList<CategoryDto>();
		for (Category category : allCategories) {
			list.add(mapper.map(category, CategoryDto.class));
		}

		return list;
	}

	@Override
	public List<CategoryResponse> findByActiveCategory() {
		List<Category> list = repo.findByIsActiveTrue();

		List<CategoryResponse> cResponses = list.stream().map(cat -> mapper.map(cat, CategoryResponse.class)).toList();
		return cResponses;
	}

}
