package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.exceptions.SongNotfoundException;

public class Playlist  {
    
    private String name;
    private String id ; 
    private List<Song> song; 
    private String createrid;
    private String activesong;
    
    
    private Integer songi= 0 ; 

   public Playlist(String createrid, String name   , List<Song> song){
    this.createrid=createrid;
   // this.id = id;
    this.song = song;
    this.name = name;

   }
   public Playlist(String createrid, String name   , List<Song> song,String id){
    this.createrid=createrid;
    this.id = id;
    this.song = song;
    this.name = name;

   }
   public Boolean containssong(Song gana){
    return song.contains(gana);
   }


   public String getcreatorid(){
    return createrid;
   }
   public String getactivesong(){
    return activesong;
      
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
           Playlist other = (Playlist) obj;
       if (id == null) {
           if (other.id != null)
               return false;
       } else if (!id.equals(other.id))
           return false;
       return true;
   }
   
   
   

  
    
    
   
    public Playlist(String createrid,String name, String id   , List<Song> song){
        this.createrid=createrid;

        this.name = name ;
        this.id = id;
        
        this.song = song;
        
    }
   
    public String getName(){
        return name;
    }
    public String getid(){
        return  id;
    }
    public List<Song> getsonglist(){
        return song;
       }
    public List<String> getsongids(){
         List<String>ans = new ArrayList<>();
         for(Song s : song){
            ans.add(s.getid());
         }
         return ans;
         
         
       }
   
    public void addsong(Song gana){
        
        song.add(gana);
        
    }
    public void removesong(Song gana) throws SongNotfoundException{
        Boolean removed = song.removeIf(s->s.getid().equals(gana.getid()));
        if(removed){
            // if(songi>0){
            //     songi--;
            // }else{
            //     songi=0;
            // }
            return ;

        }else{
             System.out.print("Some Requested Songs Not Available. Please try again");
        }
    }
    public Song next() throws SongNotfoundException{
     
        if(song.size()==0){
            throw new SongNotfoundException();
        }
        if(songi.equals(song.size()-1)){
            songi=0;
            return song.get(songi);
        }
        songi = songi + 1 ;
         
        return song.get(songi);

    }
    public Song prev() throws SongNotfoundException{
        if(song.size()==0){
            throw new SongNotfoundException();
        } 
        if(songi.equals(0)){
            songi=song.size()-1;
            return song.get(songi);
        }
        songi = songi - 1 ;
        return song.get(songi);
        
        // return play();
        
       
    }
    public Song play() throws SongNotfoundException {
        
        if(song.size()==0){
            throw new SongNotfoundException("Playlist is empty.");
        }
        return song.get(songi);
    }
    public Song getSong(String songid) throws SongNotfoundException {

       for(Song s : song){
          if(s.getid().equals(songid)){
           // songi = Integer.parseInt(s.getid());
           songi = song.indexOf(s);
            return s;
          }
       }
       throw new SongNotfoundException("Given song id is not a part of the active playlist");

    }
    public Song playbysongid(String id) throws SongNotfoundException {
        
       
        return song.get(songi);
    }
  
  

    
}
