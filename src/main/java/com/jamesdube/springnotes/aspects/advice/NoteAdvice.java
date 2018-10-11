package com.jamesdube.springnotes.aspects.advice;

import com.jamesdube.springnotes.models.Note;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class NoteAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("com.jamesdube.springnotes.aspects.pointcuts.NotePointcut.handleCreateNoteRequest() && args (note)")
    public void executeCreateNoteRequest(Note note){

        logger.info("CREATE NOTE REQUEST title -> {} :: content -> {}", note.getTitle(),note.getContent());
    }
}
