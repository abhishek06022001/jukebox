package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.exceptions.PlaylistnotfoundException;

public class User extends Baseentity {
 
  
    private final String name;
    private List<Playlist> playlist;
    private String activePlaylist;
    public User(String name ){
        this.name = name;
        this.playlist = new ArrayList<>();
    }
    public User(String name,String id){
        this.name = name;
        this.id= id;
        this.playlist = new ArrayList<>();
    
    }
    public void  setActiveplaylist(String play){
        this.activePlaylist= play;
    }
    public String getactiveplaylist(){
        return activePlaylist;
    }


   

    public User(String name,List<Playlist> playlist,String id){
        this(name,id);
        this.playlist=playlist;
    }
    public String getid(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void addplaylist(Playlist entity){
        playlist.add(entity);
    }
    public void modifiedplaylist(Playlist entity){
        playlist.removeIf(p->p.getid().equals(entity.getid()));
        playlist.add(entity);
    }
  
    
    public void  deleteplaylistbyid(String Playlist) throws PlaylistnotfoundException {
        Boolean bool = playlist.removeIf(p->p.getid().equals(Playlist));
        if(!bool){
            throw new  PlaylistnotfoundException();


        }
         
      
        //idk
    }
    public Playlist selectplaylist(String playlistid) throws PlaylistnotfoundException{
         for(Playlist idk : playlist){
            if(idk.getid().equals(playlistid)){
               return idk;
            }
            
         }
         throw new  PlaylistnotfoundException();
       

    }
    @Override
    public String toString(){

        return id + " " + name;

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
           User other = (User) obj;
       if (id == null) {
           if (other.id != null)
               return false;
       } else if (!id.equals(other.id))
           return false;
       return true;
   }
   
    
    
}
