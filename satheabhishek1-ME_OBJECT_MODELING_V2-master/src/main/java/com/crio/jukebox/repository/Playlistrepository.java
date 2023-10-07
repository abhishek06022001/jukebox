package com.crio.jukebox.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import com.crio.jukebox.dto.SongDTO;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.PlaylistnotfoundException;

public class Playlistrepository implements IPlaylistrepo {
   

    private static Integer counter =0;
    private final Map<String,Playlist> hmap ;
    private Integer activeplaylist = 0 ; 
    public Playlistrepository(){
        hmap= new HashMap<String,Playlist>();
    }
    public Playlistrepository(Map<String,Playlist> hmap , Integer counter){
       
      this.hmap = hmap;
      this.counter = counter;
      
        
    }
    public Playlist getactiveplaylist(){
        return hmap.get(activeplaylist.toString());
    }


    @Override
    public Playlist save(Playlist entity) {
       
        if(entity.getid()==null){
             counter++;
            Playlist ans = new Playlist(entity.getcreatorid(), entity.getName(), entity.getsonglist(),counter.toString());
             hmap.put(counter.toString(),ans);
             return ans; 
        }else{
            hmap.put(entity.getid(),entity);
            return entity ;
        } 
           
         //  
        
     

        
        

       
    }

    @Override
    public List<Playlist> findAll() {
        // TODO Auto-generated method stub
        Set set = hmap.keySet();
        List<Playlist> ans = new ArrayList<>(set);
        return ans;
    }

    @Override
    public Playlist findById(String id) {
        // TODO Auto-generated method stub
       // Optional.ofNullable(hmap.get(id));
       
       return hmap.get(id);
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Playlist entity) {
         String keyid = entity.getid();
        if(hmap.containsKey(keyid)){
            hmap.remove(keyid);
        }

    }

    @Override
    public void deleteById(String keyid) throws PlaylistnotfoundException{
        // TODO Auto-generated method stub
        if(hmap.containsKey(keyid)){
            hmap.remove(keyid);
        }else{
            throw new PlaylistnotfoundException();
        }


        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public Playlist getplaylistbycreatorandplaylistid(String creatorid, String playlistid) throws PlaylistnotfoundException{
        // TODO Auto-generated method stub
        // for (Map.Entry<String, Playlist> entry : hmap.entrySet()) {
        //     Playlist playlist = entry.getValue();
        //     String id = playlist.getid();
        //     if (playlist != null && playlist.getid().equals(playlistid)) {
        //         return playlist;
        //     }
        // }
       // Playlist p = findById(playlistid);
       
        return findById(playlistid);
        
       // throw new PlaylistnotfoundException("Playlistnot found");
        
    }
   

    
   


   
    
}
