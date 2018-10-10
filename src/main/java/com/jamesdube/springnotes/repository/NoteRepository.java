package com.jamesdube.springnotes.repository;

import com.jamesdube.springnotes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
