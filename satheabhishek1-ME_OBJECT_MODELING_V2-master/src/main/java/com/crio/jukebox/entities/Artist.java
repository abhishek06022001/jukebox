package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class Artist  extends Baseentity {
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
    


    public String getName(){
        return name;
    }
    public String getid(){
        return id;
    }
    
    
}
