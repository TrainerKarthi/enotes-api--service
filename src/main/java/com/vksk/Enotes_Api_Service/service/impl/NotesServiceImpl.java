package com.vksk.Enotes_Api_Service.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.vksk.Enotes_Api_Service.dto.NotesDto;
import com.vksk.Enotes_Api_Service.entity.Notes;
import com.vksk.Enotes_Api_Service.repository.NotesRepository;
import com.vksk.Enotes_Api_Service.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean saveNotes(NotesDto notesDto) {

		Notes notes = modelMapper.map(notesDto, Notes.class);

		Notes savedNotes = notesRepo.save(notes);

		if (ObjectUtils.isEmpty(savedNotes))
			return false;

		return true;
	}

	@Override
	public List<NotesDto> fetchAllNotes() {

		List<Notes> list = notesRepo.findAll();

		List<NotesDto> result = list.stream()
								.map(note -> modelMapper.map(note, NotesDto.class))
								.toList();

		return result;
	}

}
