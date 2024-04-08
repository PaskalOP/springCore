package com.example.springCore;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Data
@Service
@RequiredArgsConstructor
public class NoteService {

    private final List<Note> allNotes;
    private final  List<Long> allNotesId;


    public void printAllNotes (){
        allNotes.stream().forEach(p-> System.out.println(p));
    }
    public  void printAllId(){
        for (Long id: allNotesId) {
            System.out.println(id);
        }
    }
    public List<Note> listAll(){
        return this.allNotes;
    }
    public Note add(Note note){
        long id = generateID();
        note.setId(id);
        allNotes.add(note);
        allNotesId.add(id);
        return note;
    }
    private long generateID(){
        Random random = new Random();
        long newID = random.nextLong();
        boolean isUnic = false;
        while (!isUnic){
            if(allNotesId.contains(newID))  newID = random.nextLong();
            else isUnic =true;
        }
        return newID;
    }
    public Note getNodeById(long id){
        for (Note note:allNotes) {
                if(note.getId()==id) return note;
            }
        throw new NullPointerException();
    }

    public void deleteById(long id){
        Note note = getNodeById(id);
        allNotes.remove(note);
        allNotesId.remove(note.getId());
    }
    public void update(Note note){
        boolean haveElement =false;
        for (Note item :allNotes) {
            if(item.getId()==note.getId()) {
                item.setTitle(note.getTitle());
                item.setContent(note.getContent());
                haveElement = true;
            }
        }
        if(!haveElement)  throw new NullPointerException();

    }

}
