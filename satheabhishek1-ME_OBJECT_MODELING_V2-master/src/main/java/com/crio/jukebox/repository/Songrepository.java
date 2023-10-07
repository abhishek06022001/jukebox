package com.crio.jukebox.repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.SongNotfoundException;

public class Songrepository implements ISongrepo {
   
    /*  

    
 

 */
   

   

    private final Map<String,Song> songmap ;
    


    // public Songrepository(){
    //     songmap = new HashMap<String,Song>();
        

    // }
    
    public Songrepository(){
        songmap = new HashMap<String,Song>();
        
    }
    
    


    @Override
    public Song save(Song entity) {
        // TODO Auto-generated method stub
        songmap.put(entity.getid(),entity);
       // return null;
       return entity;
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
        return null;
    }




    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        for(Map.Entry<String,Song> entry : songmap.entrySet()){
            if(entry.getKey().equals(id)){
                return true ;
            }
        }
        return false;
    }

    @Override
    public void delete(Song entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

   

    @Override
    public Song findById(String id) {
        // TODO Auto-generated method stub
        return (songmap.get(id)) ;
    }

    
}
