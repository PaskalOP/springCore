package com.example.springCore;

import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Data
public class Note {

    private long id;
    private String title;
    private String content;


    public Note (String title, String content){
        this.title=title;
        this.content = content;
    }


}
