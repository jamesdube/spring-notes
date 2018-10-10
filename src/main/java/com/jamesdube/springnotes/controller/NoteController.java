package com.jamesdube.springnotes.controller;

import com.jamesdube.springnotes.exception.ResourceNotFoundException;
import com.jamesdube.springnotes.models.Note;
import com.jamesdube.springnotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    // Get All Notes
    @RequestMapping("/notes")
    public List<Note> index(){
        return noteRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/notes")
    public Note create(@Valid @RequestBody Note note){

        noteRepository.save(note);

        return note;
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public Note find(@PathVariable(value = "id") Long noteId){

        Optional<Note> note = noteRepository.findById(noteId);

        if (!note.isPresent()) throw new ResourceNotFoundException("Note", "id", noteId);

        return note.get();

    }

    // Update a Note
    @PutMapping("notes/{id}")
    public Note store(@PathVariable("id") Long noteId, @Valid @RequestBody Note noteDetails){

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        return noteRepository.save(note);

    }

    // Delete a Note
    @DeleteMapping("notes/{id}")
    public ResponseEntity delete(@PathVariable("id") Long noteId){

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note","id",noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }

}
