package com.vksk.Enotes_Api_Service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotesDto {

	private int id;

	private String title;

	private String description;

	private CategoryDto category;

	private Integer createdBy;

	private Date createdOn;

	private Integer updatedBy;

	private Date updatedOn;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	private static class CategoryDto {
		private int id;

		private String name;
	}
}
