package com.crio.jukebox.entities;


public class Genre extends Baseentity {
    private String id ; 
     private  String name;
    public Genre(String name){
        this.name=name ;
    }
    public Genre(String id,String name){
        this(name);
        this.id = id;
    }
    public String getName(){
        return name ;
    } 
    public String getid(){
        return id;
    }


    
}
