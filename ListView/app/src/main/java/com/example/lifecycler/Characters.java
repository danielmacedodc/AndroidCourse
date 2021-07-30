package com.example.lifecycler;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class Characters {

    private String name;
    private int imgId;// = {R.drawable.myoda, R.drawable.admiralackbar, R.drawable.c3po, R.drawable.darthvader, R.drawable.gengrevious, R.drawable.governormofftarkin, R.drawable.hansolo, R.drawable.lukesky, R.drawable.obiwan, R.drawable.padmeamidala, R.drawable.quigonjinn};

    public Characters(String name, int imgId){
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

//    public static ArrayList<String> getListFullName() {
//        return new ArrayList<>(mapOfState().values());
//    }

//    public static Integer[] getimgDd(){
//        return Integer[]
//    }

//    public static ArrayList<String> getListShortName() {
//        return new ArrayList<>(mapOfState().keySet());
//    }
//
//    public static HashMap<Integer, String> mapOfState() {
//        HashMap<Integer, String> characters = new HashMap<>();
//        characters.put(R.drawable.myoda, "Master Yoda");
//        characters.put(R.drawable.admiralackbar, "Admiral Ackbar");
//        characters.put(R.drawable.c3po, "C-3PO");
//        characters.put(R.drawable.darthvader, "Darth Vader");
//        characters.put(R.drawable.gengrevious, "General Grevious");
//        characters.put(R.drawable.governormofftarkin, "Governor Moff Tarkin");
//        characters.put(R.drawable.hansolo, "Han Solo");
//        characters.put(R.drawable.lukesky, "Luke Skywalker");
//        characters.put(R.drawable.obiwan, "Obi-Wan Kenobi");
//        characters.put(R.drawable.padmeamidala, "Padmé Amidala");
//        characters.put(R.drawable.quigonjinn, "Qui-Gon Jinn");
//        return characters;
//    }
}
