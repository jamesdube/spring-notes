package com.jamesdube.springnotes.aspects.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NotePointcut {

    @Pointcut("execution(* com.jamesdube.springnotes.controller.NoteController.create(..))")
    public void handleCreateNoteRequest() {}
}
