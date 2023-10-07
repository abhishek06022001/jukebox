package com.crio.jukebox.dto;

import java.util.List;
import com.crio.jukebox.entities.Album;
import com.crio.jukebox.entities.Artist;
import com.crio.jukebox.entities.Baseentity;

public class SongDTO extends Baseentity {
//     Song  -  { Song Name  } 
// Album - { Album Name  }  
// Artists - { List of Artists 
   private String songname;
   private  Album album;
   private  List<Artist> featureartists;
    public SongDTO(String songname, Album hisalbum, List<Artist> featureartists){
        this.songname = songname ; 
        this.album = hisalbum;
        this.featureartists=featureartists;
    }
    public String getsongname(){
        return songname;
    }
    public String getalbumname(){
        return album.getname();
    }
    public String getfeatureartist(){
        String s = "";
        for(Artist e : featureartists){
               s+=e.getName();
               s+=",";

        }
        
         return s.substring(0, s.length() - 1);
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
            SongDTO other = (SongDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if( songname == null)   {
            if (other.songname != null)
                return false;
        }else if (!songname.equals(other.songname))
            return false;
        return true;
    }
    

    
    @Override
    public String toString(){
         return "Current Song Playing"+"\n"+
                  "Song"+ " - " +songname+ "\n"+
                  "Album" + " - " + album+"\n"+
                  "Artist" + " - " +featureartists+"\n";


    }
}
