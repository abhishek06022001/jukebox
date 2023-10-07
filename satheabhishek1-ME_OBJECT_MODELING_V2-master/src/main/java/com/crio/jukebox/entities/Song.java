package com.crio.jukebox.entities;

import java.util.List;

public class Song extends Baseentity{
    private String name ;
    private Album album ; 
    private String id;
    private List <Artist> artist;
    private Genre genre;
    private Artist songowner;
    
    
    public Song(String name,String id){
        this.id = id;
        this.name = name;
    }
    public Song(String name,String id,Album album){
        this(name,id);
        this.album = album;
    }
    public Song(String id , String name , Genre genre, Album album, Artist songowner,List <Artist> artiss ){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.album = album;
        this.songowner= songowner;
        this.artist=artiss;
    }
    public String getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public Album getAlbum(){
        return album;
    }
    public List <Artist> getArtist(){
        return artist;
    }
    public Genre getgenre(){
        return genre;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
            Song other = (Song) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
   
    
    
    


    
}
