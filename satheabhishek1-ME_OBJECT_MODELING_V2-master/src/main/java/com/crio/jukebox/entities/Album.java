package com.crio.jukebox.entities;

import java.util.List;

public class Album extends Baseentity{
    private String name ;
    private List<Song> song;
    private Artist artist;
    public Album(String name){
      
        this.name = name;
    }
    
    public Album(String name, String id ){
        this.id = id;
        this.name = name;
    }
    public Album(String name , String id , List<Song> song){
        this.name = name;
        this.id = id;
        this.song = song;
    }
    public void addSong(Song gana) {
        song.add(gana);
    }
    public String getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public Artist getAlbumowner(){
        return artist;
    }
    public List<Song> getsongs(){
        return song;
    }
   
    
   
    
}
