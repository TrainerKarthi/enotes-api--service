package com.vksk.Enotes_Api_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vksk.Enotes_Api_Service.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

}
