package com.vksk.Enotes_Api_Service.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vksk.Enotes_Api_Service.dto.NotesDto;
import com.vksk.Enotes_Api_Service.entity.Notes;
import com.vksk.Enotes_Api_Service.service.NotesService;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public boolean saveNotes(@RequestBody Notes notes) {

		System.out.println("-->"+notes);
		NotesDto notesDto = mapper.map(notes, NotesDto.class);
		System.out.println(notesDto);
		boolean saveNotes = notesService.saveNotes(notesDto);

		return saveNotes;

	}

	@GetMapping
	public List<NotesDto> fetchAllNotes() {

		List<NotesDto> allNotes = notesService.fetchAllNotes();

		return allNotes;
	}

}
