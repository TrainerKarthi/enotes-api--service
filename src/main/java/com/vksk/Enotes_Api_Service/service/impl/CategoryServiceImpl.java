package com.vksk.Enotes_Api_Service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.vksk.Enotes_Api_Service.dto.CategoryDto;
import com.vksk.Enotes_Api_Service.dto.CategoryResponse;
import com.vksk.Enotes_Api_Service.entity.Category;
import com.vksk.Enotes_Api_Service.repository.CategoryRepository;
import com.vksk.Enotes_Api_Service.service.CategoryService;
import com.vksk.Enotes_Api_Service.utils.Validation;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validation validation;

	@Override
	public boolean saveCategory(CategoryDto categoryDto) {

//		Category category = new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());

//		Validating CategoryDto
		validation.categoryValidation(categoryDto);
		
		Category category = mapper.map(categoryDto, Category.class);
		if (ObjectUtils.isEmpty(category.getId())) {

			category.setIsDeleted(false);
			category.setCreatedBy(1);
			category.setCreatedOn(new Date());
		} else {
			updateCategory(category);
		}

		Category category2 = repo.save(category);

		return !ObjectUtils.isEmpty(category2);
	}

	private void updateCategory(Category category) {

		Optional<Category> optional = repo.findById(category.getId());

		if (optional.isPresent()) {
			Category existCategory = optional.get();

			category.setIsDeleted(existCategory.getIsDeleted());
			category.setCreatedBy(existCategory.getCreatedBy());
			category.setCreatedOn(existCategory.getCreatedOn());

			category.setUpdatedBy(1);
			category.setUpdatedOn(new Date());
		}

	}

	@Override
	public List<CategoryDto> findNotDeletedCategories() {

		List<Category> allCategories = repo.findByIsDeletedFalse();

		List<CategoryDto> list = new ArrayList<CategoryDto>();
		for (Category category : allCategories) {
			list.add(mapper.map(category, CategoryDto.class));
		}

		return list;
	}

	@Override
	public List<CategoryResponse> findByActiveAndNotDeletedCategory() {
		List<Category> list = repo.findByIsActiveTrueAndIsDeletedFalse();

		List<CategoryResponse> cResponses = list.stream().map(cat -> mapper.map(cat, CategoryResponse.class)).toList();
		return cResponses;
	}

	@Override
	public CategoryDto findByCategoryIdAndNotDeleted(int id) {

		Optional<Category> optional = repo.findByIdAndIsDeletedFalse(id);

		if (optional.isPresent()) {
			return mapper.map(optional.get(), CategoryDto.class);
		}

		return null;
	}

	@Override
	public boolean deleteById(int id) {
		Optional<Category> optional = repo.findById(id);

		if (optional.isPresent()) {
			Category category = optional.get();
			category.setIsDeleted(true);
			repo.save(category);
			return true;
		}

		return false;
	}

}
