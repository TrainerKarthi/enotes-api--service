package com.vksk.Enotes_Api_Service.service;

import java.util.List;

import com.vksk.Enotes_Api_Service.dto.NotesDto;

public interface NotesService {
	
	boolean saveNotes(NotesDto notesDto);
	
	List<NotesDto> fetchAllNotes();

}
