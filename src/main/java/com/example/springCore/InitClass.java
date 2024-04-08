package com.example.springCore;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitClass {

    NoteService noteService;
    public InitClass (NoteService noteService){
        this.noteService = noteService;
    }
    Note note2 = new Note("Test2","Content2");
    Note note3 = new Note("Test3","Content3");
    Note note4 = new Note("Test4","Content4");
    @PostConstruct
    public void init(){
        noteService.add(note2);
        noteService.add(note3);
        Long id = note3.getId();
        noteService.printAllNotes();
        noteService.printAllId();

        //System.out.println(noteService.getNodeById(5L));
        System.out.println(noteService.getNodeById(id));
       // noteService.deleteById(id);
       // System.out.println("We delated note with id "+ id);
        note4.setId(id);
        noteService.printAllNotes();
        noteService.printAllId();

        System.out.println(note4);
        noteService.update(note4);
        System.out.println("We update element  with id "+ id);
        noteService.printAllNotes();
        noteService.printAllId();
    }
}
