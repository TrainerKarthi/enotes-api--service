package com.vksk.Enotes_Api_Service.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.vksk.Enotes_Api_Service.dto.CategoryDto;
import com.vksk.Enotes_Api_Service.exceptions.ValidationException;

@Component
public class Validation {

	public void categoryValidation(CategoryDto categoryDto) {
		Map<String, String> error = new LinkedHashMap<String, String>();
		if (ObjectUtils.isEmpty(categoryDto)) {
			throw new IllegalArgumentException("Please provide Json/Object");
		}

		if (ObjectUtils.isEmpty(categoryDto.getName())) {
			error.put("name", "name should not be null");
		} else if (!(categoryDto.getName().length() >= 5 && categoryDto.getName().length() <= 50)) {
			error.put("name", "name length should between 5 and 50");
		}

		if (ObjectUtils.isEmpty(categoryDto.getDescription()))
			error.put("description", "description should not be null");
		else if (!(categoryDto.getDescription().length() >= 5 && categoryDto.getDescription().length() <= 50)) {
			error.put("description", "description length should between 5 and 50");
		}

		if (ObjectUtils.isEmpty(categoryDto.getIsActive())) {
			error.put("isActive", "isActive should not be null");
		}

		if (!error.isEmpty()) {
			throw new ValidationException(error);
		}

	}
}
