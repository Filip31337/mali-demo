package com.filip.malidemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filip.malidemo.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
