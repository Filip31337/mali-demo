package com.filip.malidemo.controller;

import com.filip.malidemo.exception.ResourceNotFoundException;
import com.filip.malidemo.model.Note;
import com.filip.malidemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;

	// Get All Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	// Create a new Note
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note) {
		return noteRepository.save(note);
	}

	// Get a Single Note
	// ovo je valjda drugi nacin na koji se moze mapping napisati
	// @GetMapping("/notes/{id}")
	@RequestMapping(value = "/notes/{id}", produces = "application/json", method = RequestMethod.GET)
	public Note getNoteById(@PathVariable(value = "id") Long noteId) {
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}

	// Update a Note
	@PutMapping("/notes")
	public Note updateNote(@RequestBody Note newNote) {
		Note note = noteRepository.findById(newNote.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", newNote.getId()));
		note.setTitle(newNote.getTitle());
		note.setContent(newNote.getContent());

		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}

	// Delete a Note
	@DeleteMapping("/notes/{id}")
	public boolean deleteNote(@PathVariable(value = "id") Long noteId) {
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
		
		noteRepository.delete(note);

		return true;
	}
}
